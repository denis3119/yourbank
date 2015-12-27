package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Request;
import com.yourbank.data.repository.RequestRepository;
import com.yourbank.service.bank.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin.
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public Request save(Request entity) {
        return requestRepository.saveAndFlush(entity);
    }

    @Override
    public Request findById(long ID) {
        return requestRepository.findOne(ID);
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public void delete(Request request) {

    }
}
