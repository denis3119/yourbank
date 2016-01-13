package com.yourbank.web.controller;

import com.yourbank.data.model.user.User;
import com.yourbank.service.user.UserService;
import com.yourbank.util.Misc;
import com.yourbank.util.PasswordValidator;
import com.yourbank.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 14.12.2015.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    UserService userService;

    @ResponseBody
    @Secured("ROLE_USER")
    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public User loginView() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return userService.getByEmail(userDetails.getUsername());
    }

    //  @ResponseBody
    @Secured("ROLE_USER")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/profile/index";
    }

    // @ResponseBody
    @RequestMapping(value = "/confirm/{id}/{hash}", method = RequestMethod.GET)
    public String confirm() {
        return "/profile/confirm_form";
    }

    // @ResponseBody
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirmSave(@RequestParam("password") String password,
                              @RequestParam("password_confirm") String password_confirm,
                              @RequestParam("email") String email,
                              @RequestParam("hash") int hash) throws Exception {
        validate(password, password_confirm, email, hash);
        userService.confirm(email, password);
        return "/profile/confirmed";
    }

    private void validate(@RequestParam("password") String password,
                          @RequestParam("password-confirm") String password_confirm,
                          @RequestParam("email") String email,
                          @RequestParam("hash") int hash) throws Exception {
        password = Misc.norm(password);
        if (!password.equals(password_confirm) || !PasswordValidator.validate(password)) {
            throw new Exception("password error");
        }
        User user = userService.getByEmail(email);
        if (Misc.isNull(user)) {
            throw new Exception("user not found");
        }
        if (hash != user.getEmail().hashCode()) {
            throw new Exception("hash error");
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    @Secured("ROLE_USER")
    public User changePassword(String password) {
        User savedUser = userService.getByEmail(userService.current().getEmail());
        if (PasswordValidator.validate(password)) {
            savedUser.setPassword(UserUtil.getPasswordHash(password));
            return userService.update(savedUser);
        }
        return null;
    }
}
