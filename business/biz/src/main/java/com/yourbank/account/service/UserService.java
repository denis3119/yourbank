package com.yourbank.account.service;

import com.yourbank.account.User;
import org.springframework.stereotype.Service;


/**
 * Created by admin on 11/3/2015.
 */
@Service
public interface UserService extends AbstractService<User> {
    User getByName(String name);

    User getByEmail(String name);
}
