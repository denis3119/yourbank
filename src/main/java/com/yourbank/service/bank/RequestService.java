package com.yourbank.service.bank;

import com.yourbank.data.model.bank.Request;

import java.util.List;

/**
 * @author admin.
 */
public interface RequestService {

    Request save(Request request);

    Request findById(long requestID);

    List<Request> getAll();

    void delete(Request request);
}
