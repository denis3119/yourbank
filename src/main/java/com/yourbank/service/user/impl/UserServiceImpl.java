package com.yourbank.service.user.impl;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import com.yourbank.data.repository.UserRepository;
import com.yourbank.service.user.UserProfileService;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    UserRoleService userRoleService;

    @Override
    public User register(@NotNull User registrationDto) {
        User existingUser = userRepository.getByUsername(registrationDto.getUsername());
        if (existingUser != null) {
            return null;
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(registrationDto.getEmail());
        user.setPhone(registrationDto.getPhone());
        user.setEnabled(true);

        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);

//        if (user != null && getByName(user.getUsername()) == null) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            return userRepository.saveAndFlush(user);
//        }
        return user;
    }

    public User add(@NotNull User user) {
        if (user != null && getByName(user.getUsername()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    public List<User> update(List<User> users) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            result.add(update(user));
        }
        return result;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByName(String name) {   //пусть будет
        return userRepository.getByUsername(name);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public boolean userCreated(String email) {
        return getByEmail(email) != null;
    }

    public void addRole(User user, String roleName) {
        user = getByName(user.getUsername());
//        Group role = new Group(user, roleName);
//        role = userRoleService.add(role);
//        HashSet<Group> roles = new HashSet<>(Collections.singletonList(role));
//        if (user.getGroup() != null) {
//            roles.addAll(user.getGroup());
//        }
//        user.setGroup(roles);
        update(user);
    }

    @SuppressWarnings("unchecked")
    public void setUserProfile(User user, UserProfile userProfile) {
        user.setUserProfile(userProfile);
        update(user);
//        userProfileService.add(userProfile);
    }
}
