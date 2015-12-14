package com.yourbank.data.service.impl;

import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.data.repository.UserProfileRepository;
import com.yourbank.data.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<UserProfile> update(List<UserProfile> entities) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile userProfile : entities) {
            result.add(update(userProfile));
        }
        return result;
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
