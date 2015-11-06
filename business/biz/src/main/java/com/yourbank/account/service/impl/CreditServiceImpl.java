package com.yourbank.account.service.impl;

import com.sun.istack.internal.NotNull;
import com.yourbank.account.persistence.CreditRepository;
import com.yourbank.account.service.CreditService;
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

    public Credit add(@NotNull Credit entity) {
        return creditRepository.saveAndFlush(entity);
    }

    public void delete(@NotNull Credit entity) {
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
