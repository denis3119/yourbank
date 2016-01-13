package com.yourbank.web.controller;


import com.yourbank.config.mail.EmailSender;
import com.yourbank.data.model.bank.Request;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.bank.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin.
 */
@Controller
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    CreditService creditService;

    @Autowired
    EmailSender sender;

    @RequestMapping(value = "/new/layout", method = RequestMethod.GET)
    public String newLayout() {
        return "public/create-request";
    }

    @RequestMapping(value = "/new/completed/layout", method = RequestMethod.GET)
    public String newCompletedLayout() {
        return "public/create-request-complete";
    }

    @RequestMapping(value = "/new/add", method = RequestMethod.POST)
    @ResponseBody
    public Request add(@RequestBody Request request) {
        return requestService.add(request);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> list() {
        return requestService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public List<Request> delete(@RequestBody Request request) {
        requestService.delete(request);
        return requestService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public Request approve(@RequestBody Request request) {
        request = requestService.approve(request);
        if (request != null) {
            sender.sendConfirmInBank(request.getEmail(), true, request);
        }
        return requestService.approve(request);
    }

    @ResponseBody
    @RequestMapping(value = "/unApprove", method = RequestMethod.POST)
    public Request unApprove(@RequestBody Request request) {
        request = requestService.approve(request);
        if (request != null) {
            sender.sendConfirmInBank(request.getEmail(), false, request);
        }
        return requestService.unApprove(request);
    }

    @RequestMapping(value = "/{requestID}", method = RequestMethod.GET)
    @ResponseBody
    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    public Request detail(@PathVariable long requestID) {
        return requestService.get(requestID);
    }

    @RequestMapping(value = "/remove/{requestID}/{hash}", method = RequestMethod.GET)
    @ResponseBody
    public boolean remove(@PathVariable long requestID,@PathVariable int hash) throws Exception {
        Request request = requestService.get(requestID);
        if (request == null || hash != request.getEmail().hashCode()) {
            return false;
        }
        requestService.delete(request);
        return true;
    }
}
