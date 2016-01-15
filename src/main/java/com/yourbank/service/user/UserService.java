package com.yourbank.service.user;


import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.service.common.Service;

/**
 * Created by admin on 11/3/2015.
 */
public interface UserService extends Service<User> {

    User getByEmail(String email);

    boolean userCreated(String email);

    void addRole(User user, String role);

    boolean hasRole(String string, User user);

    void confirm(Long userId, String newPassword);

    User current();

    User register(User user, String... roleList);

    User block(User user);

    User unBlock(User user);

    void setUserProfile(User user, UserProfile userProfile);

    User createUserFromRequest(Request request);
}
