package com.yourbank.data.service;


import com.yourbank.data.model.user.User;

/**
 * Created by admin on 11/3/2015.
 */
public interface UserService extends Service<User> {

    User getByName(String name);

    User getByEmail(String name);

    boolean userCreated(String name);

    void addRole(User user, String role);
}
