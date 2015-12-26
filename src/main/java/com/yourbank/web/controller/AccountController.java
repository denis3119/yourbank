package com.yourbank.web.controller;

import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* Created by admin on 11/2/2015.
*/
@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/layout", method = RequestMethod.GET)
    public String loginView() {
        return "public/login";
    }

    @RequestMapping(value = "/register/layout", method = RequestMethod.GET)
    public String registrationView() {
        return "public/register";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model) {
//        user = userService.register(user);
//        Group role = new Group(user, "ROLE_USER");
//        role = userRoleService.register(role);
//        HashSet<Group> roles = new HashSet<>(Collections.singletonList(role));
//        user.setGroup(roles);
//        System.out.println("username: " + user.getUsername());
//        System.out.println("password: " + user.getPassword());
//        System.out.println("email: " + user.getEmail());
//        userService.update(user);
//        return "registration_success";
//    }
}
