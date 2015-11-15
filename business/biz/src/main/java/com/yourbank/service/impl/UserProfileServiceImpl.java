package com.yourbank.service.impl;

import com.yourbank.UserProfile;
import com.yourbank.persistence.UserProfileRepository;
import com.yourbank.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile add(UserProfile entity) {
        return userProfileRepository.saveAndFlush(entity);
    }

    public void delete(UserProfile entity) {
        userProfileRepository.delete(entity);
    }

    public UserProfile get(long ID) {
        return userProfileRepository.getOne(ID);
    }

    public UserProfile update(UserProfile entity) {
        return userProfileRepository.saveAndFlush(entity);
    }
}
