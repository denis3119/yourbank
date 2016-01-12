package com.yourbank.service.bank.impl;

import com.yourbank.config.mail.EmailSender;
import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.data.repository.RequestRepository;
import com.yourbank.service.bank.RequestService;
import com.yourbank.service.status.RequestStatus;
import com.yourbank.service.user.UserProfileService;
import com.yourbank.service.user.UserService;
import com.yourbank.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    EmailSender sender;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserProfileService userProfileService;

    public Request add(Request entity) {
        return requestRepository.saveAndFlush(entity);
    }

    public void delete(Request entity) {
        requestRepository.delete(entity);
    }

    public Request get(long ID) {
        return requestRepository.findOne(ID);
    }

    public Request update(Request entity) {
        return requestRepository.saveAndFlush(entity);
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
    public Request approve(Request request) {
        return setStatusAndUpdate(request, RequestStatus.APPROVED);
    }

    private Request setStatusAndUpdate(Request request, RequestStatus status) {
        request.setStatus(status);
        return update(request);
    }

    @Override
    public Request unApprove(Request request) {
        return setStatusAndUpdate(request, RequestStatus.DECLINED);
    }

    @Override
    public User createUserFromRequest(Request request) {
        User user = RequestUtil.getUserFromRequest(request);
        userService.add(user);
        UserProfile userProfile = RequestUtil.getUserProfile(request);
        userProfile.setUser(user);
        userProfile = userProfileService.add(userProfile);
        user.setUserProfile(userProfile);
        sender.sendConfirmMail(user);
        return userService.update(user);
    }
}
