package com.yourbank.account.service.impl;

import com.sun.istack.internal.NotNull;
import com.yourbank.account.UserProfile;
import com.yourbank.account.persistence.UserProfileRepository;
import com.yourbank.account.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile add(@NotNull UserProfile entity) {
        return userProfileRepository.saveAndFlush(entity);
    }

    public void delete(@NotNull UserProfile entity) {
        userProfileRepository.delete(entity);
    }

    public UserProfile get(long ID) {
        return userProfileRepository.getOne(ID);
    }

    public UserProfile update(UserProfile entity) {
        return userProfileRepository.saveAndFlush(entity);
    }
}
