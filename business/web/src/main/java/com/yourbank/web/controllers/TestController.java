package com.yourbank.web.controllers;

import org.springframework.expression.spel.ast.FloatLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        final List<Long> list = Arrays.asList(3L, 4L, 10L, 5L, 8L, 4L);
        Long t = list.stream().filter(element -> list.stream().filter(elem -> elem.equals(element)).count() > 1).findFirst().orElse(null);
        model.addAttribute("message", t);
        return "test";
    }

}
