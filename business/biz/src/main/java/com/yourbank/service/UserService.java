package com.yourbank.service;

import com.yourbank.User;
import com.yourbank.UserRole;

import javax.management.relation.Role;


/**
 * Created by admin on 11/3/2015.
 */
public interface UserService extends Service<User> {

    User getByName(String name);

    User getByEmail(String name);

    boolean userCreated(String name);

    void addRole(User user, String  role);
}
