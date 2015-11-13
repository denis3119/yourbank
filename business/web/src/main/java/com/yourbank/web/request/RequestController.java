package com.yourbank.web.request;

import com.yourbank.account.persistence.RequestRepository;
import com.yourbank.account.service.RequestService;
import com.yourbank.bank.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin.
 */
@Controller
@RequestMapping(value = "/request")
public class RequestController {
    @Autowired
    RequestService requestService;
    public void add(Request request){
        requestService.add(request);
    }
}
