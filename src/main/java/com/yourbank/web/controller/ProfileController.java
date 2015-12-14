package com.yourbank.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 14.12.2015.
 */
@Controller
public class ProfileController {

    @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        modelAndView.addObject("user", userDetails);
        modelAndView.setViewName("/profile/index");
        return modelAndView;
    }
}
