package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.CreditRepository;
import com.yourbank.data.repository.UserCreditRepository;
import com.yourbank.service.bank.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserCredit approveCredit(UserCredit userCredit, User user) {
        userCredit.getCredit().setId(null);
        Credit oldCredit = add(userCredit.getCredit());
        userCredit.setCredit(oldCredit);
        userCreditRepository.saveAndFlush(userCredit);
        return userCreditRepository.saveAndFlush(userCredit);
    }

    public Credit getByCurrency(Currency currency) {
        return creditRepository.getByCurrency(currency);
    }
}
