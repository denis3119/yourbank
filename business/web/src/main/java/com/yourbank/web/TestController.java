package com.yourbank.web;

import com.yourbank.User;
import com.yourbank.UserRole;
import com.yourbank.persistence.UserRepository;
import com.yourbank.service.UserRoleService;
import com.yourbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        if (!userService.userCreated("admin")) {
            User user = new User();
            user.setName("admin");
            user.setPassword("admin");
            user = userService.add(user);
            userService.addRole(user, "ROLE_ADMIN");
            userService.addRole(user, "ROLE_USER");
        }
        if (!userService.userCreated("user")) {
            User user = new User();
            user.setName("user");
            user.setPassword("user");
            user = userService.add(user);
            userService.addRole(user, "ROLE_USER");
        }
        if (!userService.userCreated("user1")) {
            User user = new User();
            user.setName("user1");
            user.setPassword("user1");
            user = userService.add(user);
            userService.addRole(user, "ROLE_USER");
        }

        return model;
    }


    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");
        return model;
    }

}
