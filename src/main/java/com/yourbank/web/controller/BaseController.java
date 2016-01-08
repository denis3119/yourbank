package com.yourbank.web.controller;

import com.yourbank.data.model.user.User;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/public/home/layout", method = RequestMethod.GET)
    public String testHome() {
        return "public/home";
    }

    @RequestMapping(value = "/login/layout", method = RequestMethod.GET)
    public String loginView() {
        return "public/login";
    }

    @RequestMapping(value = "/account/current", method = RequestMethod.GET)
    @ResponseBody
    public User currentUser() {
        return userService.current();
    }
}
