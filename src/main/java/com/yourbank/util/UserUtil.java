package com.yourbank.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by admin on 06.01.2016.
 */
public class UserUtil {
    public static String getPasswordHash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
        return passwordEncoder.encode(password);
    }
}
