package com.yourbank.service.user;


import com.yourbank.data.model.user.User;
import com.yourbank.service.common.Service;

/**
 * Created by admin on 11/3/2015.
 */
public interface UserService extends Service<User> {

    User getByName(String name);

    User getByEmail(String name);

    boolean userCreated(String name);

    void addRole(User user, String role);

    boolean hasRole(String string, User user);
}
