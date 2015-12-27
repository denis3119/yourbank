package com.yourbank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yugov Alexandr.
 */
@Controller
@RequestMapping("")
public class BasicController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/public/home/layout", method = RequestMethod.GET)
    public String testHome() {
        return "public/home";
    }
}
