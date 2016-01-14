package com.yourbank.service.bank;

import com.yourbank.data.model.bank.Request;
import com.yourbank.service.common.Service;

/**
 * Created by admin on 11/6/2015.
 */
public interface RequestService extends Service<Request> {
        Request approve(Request request);
        Request unApprove(Request request);
}
