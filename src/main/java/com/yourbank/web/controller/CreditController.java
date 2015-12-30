package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.service.bank.CreditService;
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
@Controller
public class CreditController {

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/add_credit", method = RequestMethod.GET)
    public Credit add() {
        Credit credit = new Credit();
//        model.put("creditForm", credit);
//        model.put("currency", Credit.CurrencyCode.values());
        return credit;
    }

    @RequestMapping(value = "/add_credit", method = RequestMethod.POST)
    @ResponseBody
    public List<Credit> add(Credit credit) {
        creditService.add(credit);
//        model.put("credits", );
        return creditService.getAll();
    }

    @RequestMapping(value = "/credits", method = RequestMethod.GET)
    @ResponseBody
    public List<Credit> credits() {
        return creditService.getAll();
    }

    @RequestMapping(value = "/credit_{creditID}", method = RequestMethod.GET)
    @ResponseBody
    public Credit detail(@PathVariable long creditID) {
//        model.put("credit", );
        return creditService.get(creditID);
    }
}
