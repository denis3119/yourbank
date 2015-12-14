package com.yourbank.data.service.impl;

import com.yourbank.data.model.bank.Request;
import com.yourbank.data.repository.RequestRepository;
import com.yourbank.data.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */
@Service
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
        return requestRepository.findOne(ID);
    }

    public Request update(Request entity) {
        return requestRepository.saveAndFlush(entity);
    }

    @Override
    public List<Request> update(List<Request> entities) {
        List<Request> result = new ArrayList<>();
        for (Request request : entities) {
            result.add(update(request));
        }
        return result;
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    public List<Request> getAll(Iterable<Long> listID) {
        return requestRepository.findAll(listID);
    }
}
