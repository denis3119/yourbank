package com.yourbank.web;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserRole;
import com.yourbank.data.service.UserRoleService;
import com.yourbank.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
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
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model) {
        user = userService.add(user);
        UserRole role = new UserRole(user, "ROLE_USER");
        role = userRoleService.add(role);
        HashSet<UserRole> roles = new HashSet<>(Collections.singletonList(role));
        user.setUserRole(roles);
        System.out.println("username: " + user.getName());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        userService.update(user);
        return "registration_success";
    }
}
