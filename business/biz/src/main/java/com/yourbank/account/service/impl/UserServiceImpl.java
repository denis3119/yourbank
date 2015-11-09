package com.yourbank.account.service.impl;

import com.yourbank.account.User;
import com.yourbank.account.persistence.UserRepository;
import com.yourbank.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User get(long ID) {
        return userRepository.getOne(ID);
    }

    public User update(User entity) {
        return userRepository.saveAndFlush(entity);
    }

    public User getByName(String name) {   //пусть будет
        return userRepository.getByName(name);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

}
