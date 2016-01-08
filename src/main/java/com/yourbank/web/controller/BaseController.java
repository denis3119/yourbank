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
        createDefaultUser();
        return "index";
    }

    private void createDefaultUser() {
        if (!userService.userCreated("admin@gmail.com")) {
            User user = new User();
            user.setPassword("admin");
            user.setEmail("admin@gmail.com");
            user.setEnabled(true);
            userService.register(user, "ROLE_ADMIN", "ROLE_USER");
        }
        if (!userService.userCreated("user@gmail.com")) {
            User user = new User();
            user.setPassword("user");
            user.setEmail("user@gmail.com");
            user.setEnabled(true);
            userService.register(user, "ROLE_USER");
        }
        if (!userService.userCreated("user1@gmail.com")) {
            User user = new User();
            user.setPassword("user1");
            user.setEmail("user1@gmail.com");
            user.setEnabled(true);
            userService.register(user, "ROLE_USER");
        }
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
