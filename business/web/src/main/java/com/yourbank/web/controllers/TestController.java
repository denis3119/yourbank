package com.yourbank.web.controllers;

import com.yourbank.account.User;
import com.yourbank.account.persistence.UserRepository;
import com.yourbank.account.service.UserService;
import com.yourbank.account.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.FloatLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

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
