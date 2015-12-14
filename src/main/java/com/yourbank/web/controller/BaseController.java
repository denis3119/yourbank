package com.yourbank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yugov Alexandr.
 */
@Controller
@RequestMapping("")
public class BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/public/test/layout", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/public/home", method = RequestMethod.GET)
    public String testHome() {
        return "test";
    }
}
