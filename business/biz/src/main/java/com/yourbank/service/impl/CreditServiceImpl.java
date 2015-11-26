package com.yourbank.service.impl;

import com.yourbank.persistence.CreditRepository;
import com.yourbank.service.CreditService;
import com.yourbank.bank.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;

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
        return creditRepository.getOne(ID);
    }

    public Credit update(Credit entity) {
        return creditRepository.saveAndFlush(entity);
    }

    public Credit getByCurrency(Currency currency) {
        return creditRepository.getByCurrency(currency);
    }
}
