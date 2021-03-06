package com.yourbank.util;

import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import org.jetbrains.annotations.Contract;

import java.util.UUID;

/**
 * Created by admin on 26.12.2015.
 */
public class RequestUtil {
    @Contract("null -> null")
    public static User getUserFromRequest(Request request) {
        if (request == null) {
            return null;
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(UUID.randomUUID().toString());
        return user;
    }

    @Contract(value = "null -> null", pure = true)
    public static UserProfile fillUserProfile(Request request, UserProfile userProfile) {
        if (request == null) {
            return null;
        }
        userProfile.setFirstName(request.getFirstName());
        userProfile.setLastName(request.getLastName());
        userProfile.setPatronymic(request.getPatronymic());
        return userProfile;
    }
}
