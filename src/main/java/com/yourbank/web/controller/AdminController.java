package com.yourbank.web.controller;

import com.yourbank.data.model.user.User;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Yugov Alexandr.
 */
@Controller
@RequestMapping("admin")
@Secured("ROLE_ADMIN")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/layout", method = RequestMethod.GET)
    private String managerView() {
        return "private/admin";
    }

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    @ResponseBody
    private List<User> viewAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/unBlock", method = RequestMethod.POST)
    @ResponseBody
    public User unBlock(@RequestBody User user) {
        return userService.unBlock(user);
    }
}
