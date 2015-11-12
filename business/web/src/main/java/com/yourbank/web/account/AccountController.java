package com.yourbank.web.account;

import com.yourbank.account.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 11/2/2015.
 */
@Controller
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/sec")
    public ModelAndView sec() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sec");
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    public void registation() {

    }

    public void confirm() {

    }
}
