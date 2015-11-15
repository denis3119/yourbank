package com.yourbank.web;

import com.yourbank.User;
import com.yourbank.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        final List<Long> list = Arrays.asList(3L, 4L, 10L, 5L, 8L, 4L);
        User user= new User();
        user.setEmail("drop table user;");
        userRepository.saveAndFlush(user);
        model.addAttribute("message", "123");
        return "test";
    }

}
