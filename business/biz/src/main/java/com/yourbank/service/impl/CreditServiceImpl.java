package com.yourbank.service.impl;

import com.yourbank.bank.Credit;
import com.yourbank.persistence.CreditRepository;
import com.yourbank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;

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

    public Credit getByCurrency(Currency currency) {
        return creditRepository.getByCurrency(currency);
    }
}
