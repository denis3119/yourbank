package com.yourbank.web.controller;


import com.yourbank.data.model.bank.Request;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.bank.RequestService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String add(Map<String, Object> model) {
        Request request = new Request();
        model.put("requestForm", request);
        model.put("credits", creditService.getMapAll());
        return "/request/create";
    }

    @RequestMapping(value = "/add_request", method = RequestMethod.POST)
    public String add(Request request, Map<String, Object> model) {
        requestService.add(request);
        return "/request/list";
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String list(Map<String, Object> model) {
        model.put("requests", requestService.getAll());
        return "/request/list";
    }

    @RequestMapping(value = "/delete_request", method = RequestMethod.POST)
    public String delete(Request request, Map<String, Object> model) {
        requestService.delete(request);
        return "/request/list";
    }

    @RequestMapping(value = "/request_{requestID}", method = RequestMethod.GET)
    public String detail(@PathVariable long requestID, Map<String, Object> model) {
        Request request = requestService.get(requestID);
        model.put("request", request);
        return "/request/detail";
    }
}
