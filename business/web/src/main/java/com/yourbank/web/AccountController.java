package com.yourbank.web;

import com.yourbank.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 11/2/2015.
 */
@Controller
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/sec")
    public String secView() {
        return "sec";
    }

    @RequestMapping(value = "/login")
    public String loginView() {
        return "login";
    }

    public void registation() {

    }

    public void confirm() {

    }
}
