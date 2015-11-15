package com.yourbank.web;

import com.yourbank.service.RequestService;
import com.yourbank.bank.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author admin.
 */
@Controller
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(Request request) {
        requestService.add(request);
    }

}
