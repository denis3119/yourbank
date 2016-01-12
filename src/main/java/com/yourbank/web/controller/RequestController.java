package com.yourbank.web.controller;


import com.yourbank.config.mail.MailSender;
import com.yourbank.data.model.bank.Request;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.bank.RequestService;
import com.yourbank.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author admin.
 */
@Controller
@RequestMapping("request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    CreditService creditService;

    @Autowired
    MailSender sender;

    @RequestMapping(value = "/new/layout", method = RequestMethod.GET)
    public String newLayout() {
        return "public/create-request";
    }

    @RequestMapping(value = "/new/add", method = RequestMethod.POST)
    @ResponseBody
    public Request add(Request request) {
        return requestService.add(request);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> list() {
        return requestService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public List<Request> delete(Request request) {
        requestService.delete(request);
        return requestService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public Request approve(Request request) {
        request = requestService.approve(request);
        if (request != null) {
            sender.sendConfirmInBank(request.getEmail());
        }
        return requestService.approve(request);
    }

    @RequestMapping(value = "/{requestID}", method = RequestMethod.GET)
    @ResponseBody
    public Request detail(@PathVariable long requestID, Map<String, Object> model) {
        return requestService.get(requestID);
    }
}
