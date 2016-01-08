package com.yourbank.web.controller;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserRole;
import com.yourbank.service.user.UserRoleService;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by admin on 11/2/2015.
 */
@Controller
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/sec")
    public String secView() {
        return "sec";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public User viewRegistration(Map<String, Object> model) {
        return new User();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model) {
        user = userService.add(user);
        UserRole role = new UserRole("ROLE_USER");
        role = userRoleService.add(role);
        HashSet<UserRole> roles = new HashSet<>(Collections.singletonList(role));
        user.setUserRole(roles);
        System.out.println("username: " + user.getEmail());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        userService.update(user);
        return user;
    }
}
