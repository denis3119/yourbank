package com.yourbank.account.service.impl;

import com.sun.istack.internal.NotNull;
import com.yourbank.account.User;
import com.yourbank.account.UserProfile;
import com.yourbank.account.persistence.UserRepository;
import com.yourbank.account.service.UserProfileService;
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
    @Autowired
    UserProfileService userProfileService;

    @NotNull
    public User add(User user) {
        if (user != null && getByEmail(user.getEmail()) != null) {
            return userRepository.saveAndFlush(user);
        }
        return null;
    }

    @NotNull
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User get(long ID) {
        return userRepository.getOne(ID);
    }

    @NotNull
    public User update(User entity) {
        return userRepository.saveAndFlush(entity);
    }

    public User getByName(String name) {   //пусть будет
        return userRepository.getByName(name);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public void setUserProfile(User user, UserProfile userProfile) {
        user.setUserProfile(userProfile);
        update(user);
        userProfileService.add(userProfile);
    }

}
