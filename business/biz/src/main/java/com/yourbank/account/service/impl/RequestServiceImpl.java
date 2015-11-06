package com.yourbank.account.service.impl;

import com.yourbank.account.persistence.RequestRepository;
import com.yourbank.account.service.RequestService;
import com.yourbank.bank.Request;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 11/6/2015.
 */
@org.springframework.stereotype.Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    public Request add(Request entity) {
        return requestRepository.saveAndFlush(entity);
    }

    public void delete(Request entity) {
               requestRepository.delete(entity);
    }

    public Request get(long ID) {
        return requestRepository.getOne(ID);
    }

    public Request update(Request entity) {
        return requestRepository.saveAndFlush(entity);
    }
}
