package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.CreditRepository;
import com.yourbank.data.repository.UserCreditRepository;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.bank.RequestService;
import com.yourbank.service.bank.ScoreService;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;
    @Autowired
    UserCreditRepository userCreditRepository;

    @Autowired
    RequestService requestService;

    @Autowired
    UserService userService;

    @Autowired
    ScoreService scoreService;

    public Credit add(Credit entity) {
        return creditRepository.saveAndFlush(entity);
    }

    public void delete(Credit entity) {
        creditRepository.delete(entity);
    }

    public Credit get(long ID) {
        return creditRepository.findOne(ID);
    }

    public Credit update(Credit entity) {
        return creditRepository.saveAndFlush(entity);
    }

    @Override
    public List<Credit> update(List<Credit> entities) {
        List<Credit> result = new ArrayList<>();
        for (Credit credit : entities) {
            result.add(update(credit));
        }
        return result;
    }

    @Override
    public List<Credit> getAll() {
        return creditRepository.findAll();
    }

    @Override
    public Map<String, String> getMapAll() {
        Map<String, String> map = new TreeMap<>();
        for (Credit credit : getAll()) {
            map.put(credit.getId().toString(), credit.getName());
        }
        return map;
    }

    @Override
    @ResponseBody
    public UserCredit approveCredit(@RequestBody UserCredit credit, Long requestId) throws CloneNotSupportedException {
        Request request = requestService.get(requestId);
        //    request.setExpired(true);
        credit.setName(request.getCredit().getName());
        credit.setSum(request.getSum());
        credit.setPercent(request.getCredit().getPercent());
        credit.setDescription(request.getCredit().getDescription());
        credit.setCurrency(request.getCredit().getCurrency());
        credit.setTerm(request.getPeriod());
        request = requestService.add(request);
        User user = userService.createUserFromRequest(request);
        Score score = new Score();
        score.setValue(0);
        score.setCurrency(Credit.CurrencyCode.BLR);
        score.setName("123");
        credit.setScore(scoreService.add(score));
        credit = userCreditRepository.saveAndFlush(credit);
        List<UserCredit> credits = user.getUserProfile().getUserCredits();
        credits.add(credit);
        user.getUserProfile().setUserCredits(credits);
        userService.update(user);
        return credit;
    }

    public Credit getByCurrency(Currency currency) {
        return creditRepository.getByCurrency(currency);
    }
}
