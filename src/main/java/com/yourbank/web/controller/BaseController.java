package com.yourbank.web.controller;

import com.yourbank.data.model.bank.*;
import com.yourbank.data.model.user.User;
import com.yourbank.data.repository.CreditTypeRepository;
import com.yourbank.service.bank.CreditService;
import com.yourbank.service.bank.RequestService;
import com.yourbank.service.bank.ScoreService;
import com.yourbank.service.status.RequestStatus;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yugov Alexandr.
 */
@Controller
public class BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private CreditService creditService;
    @Autowired
    private CreditTypeRepository creditTypeRepository;
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        createDefaultUser();
        createCredits();
        createRequest();
        return "index";
    }

    private void createRequest() {
        if (!requestService.getAll().isEmpty()) {
            return;
        }
        Request request = new Request();
        request.setFirstName("first");
        request.setLastName("last");
        request.setPatronymic("pan");
        request.setIncome(10);
        request.setTarget("auto");
        request.setStatus(RequestStatus.PENDING);
        request.setPeriod(10);
        request.setPhoneNumber("+375 11 111 11 11");
        request.setEmail("denis3119@gmail.com");
        request.setCredit(creditService.getAll().get(0));
        requestService.add(request);
    }

    private void createCredits() {
        Credit credit = new Credit();
        credit.setCreditTypes(new CreditType("На машину"));
        credit.setCurrency(Credit.CurrencyCode.BLR);
        credit.setDescription("Не дорого на машину");
        credit.setMaxSum(100);
        credit.setMinSum(1);
        credit.setName("Надоело ездить на велосипеде?");
        credit.setPercent(20);

        Score score = new Score();
        score.setName("bank");
        score.setCurrency(Credit.CurrencyCode.BLR);
        score.setScoreTypes(new ScoreType("auto"));
        score.setValue(0);

        credit.setScore(score);
        creditService.add(credit);
    }

    private void createDefaultUser() {
        if (!userService.userCreated("admin@gmail.com")) {
            User user = new User();
            user.setPassword("admin");
            user.setEmail("admin@gmail.com");
            user.setEnabled(true);
            userService.register(user, "ROLE_ADMIN", "ROLE_USER");
        }
        if (!userService.userCreated("user@gmail.com")) {
            User user = new User();
            user.setPassword("user");
            user.setEmail("user@gmail.com");
            user.setEnabled(true);
            userService.register(user, "ROLE_USER");
        }
        if (!userService.userCreated("user1@gmail.com")) {
            User user = new User();
            user.setPassword("user1");
            user.setEmail("user1@gmail.com");
            user.setEnabled(true);
            userService.register(user, "ROLE_USER");
        }
    }

    @RequestMapping(value = "/public/home/layout", method = RequestMethod.GET)
    public String testHome() {
        return "public/home";
    }

    @RequestMapping(value = "/login/layout", method = RequestMethod.GET)
    public String loginView() {
        return "public/login";
    }

    @RequestMapping(value = "/profile/layout", method = RequestMethod.GET)
    public String profileView() {
        return "private/profile";
    }

    @RequestMapping(value = "/account/current", method = RequestMethod.GET)
    @ResponseBody
    public User currentUser() {
        return userService.current();
    }
}
