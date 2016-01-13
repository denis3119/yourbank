package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.UserCreditRepository;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.user.UserService;
import com.yourbank.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin.
 */
@Controller
@RequestMapping(value = "/credit")
public class CreditController {

    @Autowired
    CreditService creditService;
    @Autowired
    UserCreditRepository userCreditRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String add() {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public List<Credit> add(Credit credit) {
        creditService.add(credit);
        return creditService.getAll();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Credit> credits() {
        return creditService.getAll().stream().filter(credit -> !credit.isExpired()).collect(Collectors.toCollection(LinkedList::new));
    }

    @RequestMapping(value = "/allCredits", method = RequestMethod.GET)
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public List<Credit> activeCredits() {
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
    public UserCredit approve(UserCredit userCredit, User user, double sum, int term) throws CloneNotSupportedException {
        return creditService.approveCredit(userCredit, user, sum, term);
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public List<UserCredit> allUserCredits() {
        return userCreditRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllByUser", method = RequestMethod.POST)
    public List<UserCredit> allUserCredit() {
        return userService.getByEmail(UserUtil.getCurrentUserDetailInfo().getUsername()).getUserCredits();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllNotPaidAccrual", method = RequestMethod.GET)
    public List<Accrual> getAllNotPaidAccrual(User user) {
        user = userService.getByEmail(user.getEmail());
        List<Accrual> accruals = new ArrayList<>();
        for (UserCredit credit : user.getUserCredits()) {
            accruals.addAll(credit.getAccruals().stream().filter(accrual -> !accrual.isPaid()).collect(Collectors.toList()));
        }
        return accruals;
    }

}
