package com.yourbank.config.security;

import com.yourbank.data.model.user.User;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by admin on 13.01.2016.
 */
@Component
public class LoginFail implements AuthenticationFailureHandler {
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String email = httpServletRequest.getParameter("username");
        User user = userService.getByEmail(email);
        if (user != null) {
            userService.block(user);
            System.err.println("block " + user.getEmail());
        }
        httpServletResponse.setStatus(401);
        httpServletResponse.sendRedirect("/#/login?error");
    }
}
