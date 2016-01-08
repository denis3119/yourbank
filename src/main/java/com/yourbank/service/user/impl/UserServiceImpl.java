package com.yourbank.service.user.impl;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.data.model.user.UserRole;
import com.yourbank.data.repository.UserRepository;
import com.yourbank.service.user.UserProfileService;
import com.yourbank.service.user.UserRoleService;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

    public User add(@NotNull User user) {
        if (user != null && getByName(user.getName()) == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
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

    public User getByName(String name) {   //пусть будет
        return userRepository.getByName(name);
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
        user = getByName(user.getName());
        UserRole role = new UserRole(user, roleName);
        role = userRoleService.add(role);
        HashSet<UserRole> roles = new HashSet<>(Collections.singletonList(role));
        if (user.getUserRole() != null) {
            roles.addAll(user.getUserRole());
        }
        user.setUserRole(roles);
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
        return userRepository.getByName(authentication.getName());
//        return (User) authentication.getPrincipal();
    }

    @SuppressWarnings("unchecked")
    public void setUserProfile(User user, UserProfile userProfile) {
        user.setUserProfile(userProfile);
        update(user);
        userProfileService.add(userProfile);
    }
}
