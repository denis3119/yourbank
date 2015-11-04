package com.yourbank.account.service;

import com.yourbank.account.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 11/3/2015.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    void main(){
    }
}
