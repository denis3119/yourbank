package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Payment;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.dto.PayCreditDto;
import com.yourbank.data.model.dto.RefillDto;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.AccrualRepository;
import com.yourbank.data.repository.PaymentRepository;
import com.yourbank.service.bank.ScoreService;
import com.yourbank.service.status.PaymentType;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 11.01.2016.
 */
@Controller
@RequestMapping(value = "/score")
public class PaymentController {
    @Autowired
    UserService userService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    AccrualRepository accrualRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @ResponseBody
    @RequestMapping(value = "/pay/", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public Payment creditPay(@RequestBody PayCreditDto payCreditDto) throws Exception {
        Payment payment = new Payment();
        User user = userService.current();
        Score userScore = user.getUserProfile().getScore();
        if (userScore == null) {
            throw new Exception("");
        }
        double scoreValue = userScore.getValue();
        Accrual accrual = payCreditDto.getAccrual();
        UserCredit userCredit = payCreditDto.getCredit();
        if (scoreValue < accrual.allSum() && payCreditDto.getSum() < accrual.allSum()) {
            throw new Exception("");
        }

        double value = accrual.allSum();
        double rest = payCreditDto.getSum() - value;
        userScore.setValue(userScore.getValue() - value);
        userScore = scoreService.update(userScore);
        accrual.setPaid(true);
        accrualRepository.saveAndFlush(accrual);
        userCredit.setSum(userCredit.getSum() - value);
        payment.setUser(user);
        payment.setUserCredit(userCredit);
        payment.setValue(value);
        payment.setPaymentType(PaymentType.CREDIT);
        if (rest > 0) {
            double crib = Math.abs(userCredit.getSum() - rest);
            if (userCredit.getSum() < rest) {
                userScore.setValue(0);
            } else {
                userCredit.setSum(userCredit.getSum() - rest);
            }
            userScore.setValue(userScore.getValue() - crib);
        }
        return paymentRepository.saveAndFlush(payment);
    }

    @RequestMapping(value = "/refill", method = RequestMethod.POST)
    @ResponseBody
    public Score refill(@RequestBody RefillDto refillDto) throws Exception {
        if (refillDto.getValue() < 0) {
            throw new Exception("value < 0");
        }
        User user = userService.current();
        Score score = user.getUserProfile().getScore();
        score.setValue(score.getValue() + refillDto.getValue());
        return scoreService.update(score);
    }
}
