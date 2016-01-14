package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.RequestRepository;
import com.yourbank.data.repository.UserCreditRepository;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.user.UserService;
import com.yourbank.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping(value = "/new/layout", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
    public String create() {
        return "private/create-credit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public List<Credit> add(@RequestBody Credit credit) {
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
    @Secured("ROLE_ADMIN")
    public List<Credit> Delete(@RequestBody Credit credit) {
        creditService.delete(credit);
        return creditService.getAll();
    }

    @RequestMapping(value = "/{creditID}", method = RequestMethod.GET)
    @ResponseBody
    public Credit detail(@PathVariable long creditID) {
        return creditService.get(creditID);
    }

    @ResponseBody
    @RequestMapping(value = "/approve/{requestId}", method = RequestMethod.POST)
    public UserCredit approve(@RequestBody UserCredit userCredit, @PathVariable Long requestId) throws CloneNotSupportedException {
        Request request = requestRepository.findOne(requestId);
        request.setExpired(true);
        requestRepository.saveAndFlush(request);
        return creditService.approveCredit(userCredit, request);
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
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/getAllNotPaidAccrual", method = RequestMethod.GET)
    public List<Accrual> getAllNotPaidAccrual(@RequestBody User user) {
        user = userService.getByEmail(user.getEmail());
        List<Accrual> accruals = new ArrayList<>();
        for (UserCredit credit : user.getUserCredits()) {
            accruals.addAll(credit.getAccruals().stream().filter(accrual -> !accrual.isPaid()).collect(Collectors.toList()));
        }
        return accruals;
    }

}
