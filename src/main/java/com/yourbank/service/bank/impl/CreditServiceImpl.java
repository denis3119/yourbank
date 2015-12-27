package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.repository.CreditRepository;
import com.yourbank.service.bank.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author admin.
 */
@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;

    @Override
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

    public Credit getByCurrency(Currency currency) {
        return creditRepository.getByCurrency(currency);
    }
}
