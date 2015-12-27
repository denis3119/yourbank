package com.yourbank.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Created by admin on 14.12.2015.
*/
@Controller
public class ProfileController {

    @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    @ResponseBody
    public UserDetails loginView() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
