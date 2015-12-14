package com.yourbank.web.controller;

import com.yourbank.data.model.user.User;
import com.yourbank.service.user.UserRoleService;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        createDefaultUser();

        return model;
    }

    private void createDefaultUser() {
        if (!userService.userCreated("admin")) {
            User user = new User();
            user.setName("admin");
            user.setPassword("admin");
            user.setEmail("admin@gmail.com");
            user = userService.add(user);
            userService.addRole(user, "ROLE_ADMIN");
            userService.addRole(user, "ROLE_USER");
        }
        if (!userService.userCreated("user")) {
            User user = new User();
            user.setName("user");
            user.setPassword("user");
            user.setEmail("user@gmail.com");
            user = userService.add(user);
            userService.addRole(user, "ROLE_USER");
        }
        if (!userService.userCreated("user1")) {
            User user = new User();
            user.setName("user1");
            user.setPassword("user1");
            user.setEmail("user1@gmail.com");
            user = userService.add(user);
            userService.addRole(user, "ROLE_USER");
        }
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
