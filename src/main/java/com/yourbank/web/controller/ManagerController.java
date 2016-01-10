package com.yourbank.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yugov Alexandr.
 */
@Controller
@RequestMapping("manager")
@Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
public class ManagerController {

    @RequestMapping(value = "/layout", method = RequestMethod.GET)
    private String managerView() {
        return "private/manager";
    }
}
