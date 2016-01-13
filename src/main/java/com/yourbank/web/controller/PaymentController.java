package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Payment;
import com.yourbank.data.model.bank.Score;
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
@RequestMapping(value = "/score/")
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
    @Secured("USER_ROLE")
    public Payment creditPay(@RequestBody UserCredit userCredit, @RequestBody Accrual accrual) {
        Payment payment = new Payment();
        User user = userService.current();
        Score userScore = user.getScore();
        if (userScore == null) {
            return null;
        }
        double scoreValue = userScore.getValue();
        if (scoreValue < accrual.allSum()) {
            return null;
        }
        double value = accrual.allSum();
        userScore.setValue(userScore.getValue() - value);
        scoreService.update(userScore);
        accrual.setPaid(true);
        accrualRepository.saveAndFlush(accrual);
        userCredit.setSum(userCredit.getSum() - value);
        payment.setUser(user);
        payment.setUserCredit(userCredit);
        payment.setValue(value);
        payment.setPaymentType(PaymentType.CREDIT);
        return paymentRepository.saveAndFlush(payment);
    }

    @ResponseBody
    @RequestMapping(value = "/pay/", method = RequestMethod.POST)
    @Secured("USER_ROLE")
    public void creditPay(@RequestBody UserCredit userCredit, @RequestBody int value) {

    }
}
