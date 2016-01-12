package com.yourbank.service.user.impl;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.data.model.user.UserRole;
import com.yourbank.data.repository.UserProfileRepository;
import com.yourbank.data.repository.UserRepository;
import com.yourbank.service.user.UserProfileService;
import com.yourbank.service.user.UserRoleService;
import com.yourbank.service.user.UserService;
import com.yourbank.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public User add(@NotNull User user) {
        if (user != null && getByEmail(user.getEmail()) == null) {
            UserProfile userProfile = new UserProfile();
            user.setUserProfile(userProfile);
            user.setPassword(UserUtil.getPasswordHash(user.getPassword()));
            return userRepository.saveAndFlush(user);
        }
        return user;
    }

    public void delete(@NotNull User user) {
        userRepository.delete(user);
    }

    public User get(long ID) {
        return userRepository.getOne(ID);
    }

    public User update(@NotNull User entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public List<User> update(List<User> users) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            result.add(update(user));
        }
        return result;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public boolean userCreated(String email) {
        return getByEmail(email) != null;
    }

    @Override
    public void addRole(User user, String roleName) {
        user = getByEmail(user.getEmail());
        UserRole role = new UserRole(roleName);
        role = userRoleService.add(role);
        user.getUserRole().add(role);
        update(user);
    }

    @Override
    public boolean hasRole(String string, User user) {
        for (UserRole role : user.getUserRole()) {
            if (role.getRole().equals(string)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User current() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.getByEmail(authentication.getName());
//        return (User) authentication.getPrincipal();
    }

    @Override
    public User register(User user, String... roleList) {
        user = add(user);
        for (String userRole : roleList) {
            addRole(user, userRole);
        }
        return getByEmail(user.getEmail());
    }

    @Override
    public User block(User user) {
        user.setCountErrors(user.getCountErrors() + 1);
        if (user.getCountErrors() < 3) {
            return update(user);
        }
        return setBlocked(user, true);
    }

    private User setBlocked(User user, boolean blocked) {
        user.setEnabled(!blocked);
        return update(user);
    }

    @Override
    public User unBlock(User user) {
        user.setCountErrors(0);
        return setBlocked(user, false);
    }

    @Override
    public void confirm(String email, String password) {
        User user = getByEmail(email);
        user.setPassword(UserUtil.getPasswordHash(password));
        user.setEnabled(true);
        update(user);
    }

    @SuppressWarnings("unchecked")
    public void setUserProfile(User user, UserProfile userProfile) {
        user.setUserProfile(userProfile);
        update(user);
        userProfileService.add(userProfile);
    }
}
