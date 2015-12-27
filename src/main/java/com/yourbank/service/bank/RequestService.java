package com.yourbank.service.bank;

import com.yourbank.data.model.bank.Request;

import java.util.List;
import com.yourbank.data.model.user.User;
import com.yourbank.service.common.Service;

/**
 * @author admin.
 */
public interface RequestService {

    Request save(Request request);

    Request findById(long requestID);

    List<Request> getAll();

    void delete(Request request);
    Request getByName(String name);
    Request approve(Request request);
    User createUserFromRequest(Request request);
}
