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
    public static UserProfile getUserProfile(Request request) {
        if (request == null) {
            return null;
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(request.getFirstName());
        userProfile.setLastName(request.getLastName());
        userProfile.setPatronymic(request.getPatronymic());
        userProfile.setPassportNumber(request.getPassportNumber());
        userProfile.setPersonalNumber(request.getPersonalNumber());
        return userProfile;
    }
}
