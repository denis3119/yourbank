package com.yourbank.web.controller;


import com.yourbank.data.model.bank.Request;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.bank.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
* @author admin.
*/
@Controller(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/layout", method = RequestMethod.GET)
    public String add() {
        return "public/request";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Request add(Request request) {
        return requestService.save(request);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> list() {
        return requestService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public List<Request> delete(Request request) {
        requestService.delete(request);
        return requestService.getAll();
    }

    @RequestMapping(value = "/request_{requestID}", method = RequestMethod.GET)
    @ResponseBody
    public Request detail(@PathVariable long requestID) {
        return requestService.findById(requestID);
    }
}
