package com.yourbank.web;

import com.yourbank.User;
import com.yourbank.UserRole;
import com.yourbank.persistence.UserRepository;
import com.yourbank.service.UserRoleService;
import com.yourbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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

    @RequestMapping(value = "/login")
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
        // implement your own registration logic here...
        user = userService.add(user);
        UserRole role = new UserRole(user, "ROLE_ADMIN");
        role = userRoleService.add(role);
        HashSet<UserRole> roles = new HashSet<>(Arrays.asList(role));
        user.setUserRole(roles);
        // for testing purpose:
        System.out.println("username: " + user.getName());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        userService.update(user);
        return "registration_success";
    }
}
