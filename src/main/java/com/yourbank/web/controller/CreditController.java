package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.service.bank.CreditService;
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
public class CreditController {

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/add_credit", method = RequestMethod.GET)
    public String add(Map<String, Object> model) {
        Credit credit = new Credit();
        model.put("creditForm", credit);
        model.put("currency", Credit.CurrencyCode.values());
        return "/credit/create";
    }

    @RequestMapping(value = "/add_credit", method = RequestMethod.POST)
    public String add(Map<String, Object> model, Credit credit) {
        creditService.register(credit);
        model.put("credits", creditService.getAll());
        return "/credit/list";
    }

    @RequestMapping(value = "/credits", method = RequestMethod.GET)
    public String credits(Map<String, Object> model) {
        model.put("credits", creditService.getAll());
        return "/credit/list";
    }

    @RequestMapping(value = "/credit_{creditID}", method = RequestMethod.GET)
    public String detail(@PathVariable long creditID, Map<String, Object> model) {
        model.put("credit", creditService.get(creditID));
        return "/credit/detail";
    }
}
