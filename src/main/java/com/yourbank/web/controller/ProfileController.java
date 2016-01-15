package com.yourbank.web.controller;

import com.yourbank.data.model.user.User;
import com.yourbank.data.repository.UserRepository;
import com.yourbank.service.user.UserService;
import com.yourbank.util.Misc;
import com.yourbank.util.PasswordValidator;
import com.yourbank.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 14.12.2015.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/edit/layout", method = RequestMethod.GET)
    public String editProfileLayout() {
        return "private/edit-profile";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/score/layout", method = RequestMethod.GET)
    public String editScoreLayout() {
        return "private/edit-score";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/profile/index";
    }

    @RequestMapping(value = "/confirm/{id}/{hash}", method = RequestMethod.GET)
    public ModelAndView confirm(@PathVariable Long id, @PathVariable int hash, ModelAndView modelAndView) {
        modelAndView.addObject("userId", id);
        modelAndView.addObject("hash", hash);
        modelAndView.setViewName("/profile/confirm_form");
        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirmSave(@RequestParam("password") String password,
                              @RequestParam("password_confirm") String password_confirm,
                              @RequestParam("userId") long userId,
                              @RequestParam("hash") int hash) throws Exception {
        validate(password, password_confirm, userId, hash);
        userService.confirm(userId, password);
        return "/profile/confirmed";
    }

    private void validate(@RequestParam("password") String password,
                          @RequestParam("password-confirm") String password_confirm,
                          @RequestParam("userId") long userId,
                          @RequestParam("hash") int hash) throws Exception {
        password = Misc.norm(password);
        if (!password.equals(password_confirm) || !PasswordValidator.validate(password)) {
            throw new Exception("password error");
        }
        User user = userRepository.findOne(userId);
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
    public User changePassword(@RequestBody String password) throws Exception {
        User savedUser = userService.current();
        if (PasswordValidator.validate(password)) {
            savedUser.setPassword(UserUtil.getPasswordHash(password));
            return userService.update(savedUser);
        }
       throw new Exception("error");
    }
}
