package com.yourbank.web;

import com.yourbank.User;
import com.yourbank.service.RequestService;
import com.yourbank.bank.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author admin.
 */
@Controller
public class RequestController {
    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/add_request", method = RequestMethod.GET)
    public String add(Map<String, Object> model) {
        Request request = new Request();
        model.put("requestForm", request);
        return "/request/create";
    }

    @RequestMapping(value = "/add_request", method = RequestMethod.POST)
    public String add(@ModelAttribute("requestForm") Request request, Map<String, Object> model) {
        requestService.add(request);
        return "admin";
    }
}
