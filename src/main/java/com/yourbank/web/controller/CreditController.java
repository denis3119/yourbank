package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.UserCreditRepository;
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
@RequestMapping("credit")
public class CreditController {

    @Autowired
    CreditService creditService;
    @Autowired
    UserCreditRepository userCreditRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String add() {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public List<Credit> add(Credit credit) {
        creditService.add(credit);
//        model.put("credits", );
        return creditService.getAll();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Credit> credits() {
        return creditService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Credit> Delete(Credit credit) {
        creditService.delete(credit);
        return creditService.getAll();
    }

    @RequestMapping(value = "/{creditID}", method = RequestMethod.GET)
    @ResponseBody
    public Credit detail(@PathVariable long creditID) {
        return creditService.get(creditID);
    }

    @ResponseBody
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public UserCredit approve(UserCredit userCredit, User user) {
        return creditService.approveCredit(userCredit, user);
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public List<UserCredit> allUserCredit() {
        return userCreditRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllByUser", method = RequestMethod.POST)
    public List<UserCredit> allUserCredit(User user) {
        return user.getUserCredits();
    }
}
