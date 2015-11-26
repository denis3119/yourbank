package com.yourbank.service;

import com.yourbank.User;


/**
 * Created by admin on 11/3/2015.
 */
public interface UserService extends Service<User> {

    User getByName(String name);

    User getByEmail(String name);
}
