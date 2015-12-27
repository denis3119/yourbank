package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.data.repository.RequestRepository;
import com.yourbank.service.bank.RequestService;
import com.yourbank.service.user.UserProfileService;
import com.yourbank.service.user.UserService;
import com.yourbank.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin.
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserProfileService userProfileService;

    @Override
    public Request save(Request entity) {
        return requestRepository.saveAndFlush(entity);
    }

    @Override
    public Request findById(long ID) {
        return requestRepository.findOne(ID);
    }

    @Override
    public List<Request> update(List<Request> entities) {
        List<Request> result = new ArrayList<>();
        for (Request request : entities) {
            result.add(update(request));
        }
        return result;
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public void delete(Request request) {

    }

    @Override
    public Request getByName(String name) {
        return requestRepository.getByName(name);
    }

    @Override
    public Request approve(Request request) {
        request.setApproved(true);
        return update(request);
    }

    @Override
    public User createUserFromRequest(Request request) {
        User user = RequestUtil.getUserFromRequest(request);
        userService.add(user);
        UserProfile userProfile = RequestUtil.getUserProfile(request);
        userProfile.setUser(user);
        userProfile = userProfileService.add(userProfile);
        user.setUserProfile(userProfile);
        return userService.update(user);
    }
}
