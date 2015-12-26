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
import java.util.Map;

/**
 * @author admin.
 */
@Controller
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/add_request", method = RequestMethod.GET)
    @ResponseBody
    public Request add(Map<String, Object> model) {
        Request request = new Request();
        model.put("requestForm", request);
//        model.put("credits", creditService.getMapAll());
        return request;
    }

    @RequestMapping(value = "/add_request", method = RequestMethod.POST)
    @ResponseBody
    public Request add(Request request) {
        request = requestService.add(request);
        return request;
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> list() {
        return requestService.getAll();
    }

    @RequestMapping(value = "/delete_request", method = RequestMethod.POST)
    @ResponseBody
    public List<Request> delete(Request request) {
        requestService.delete(request);
        return requestService.getAll();
    }

    @RequestMapping(value = "/request_{requestID}", method = RequestMethod.GET)
    @ResponseBody
    public Request detail(@PathVariable long requestID, Map<String, Object> model) {
        return requestService.get(requestID);
    }
}
