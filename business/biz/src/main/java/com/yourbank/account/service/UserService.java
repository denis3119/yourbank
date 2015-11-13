package com.yourbank.account.service;

import com.yourbank.account.User;


/**
 * Created by admin on 11/3/2015.
 */
public interface UserService extends Service<User> {
    User getByName(String name);

    User getByEmail(String name);
}
