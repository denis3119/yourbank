package com.yourbank.service.impl;

import com.yourbank.User;
import com.yourbank.UserProfile;
import com.yourbank.bank.Score;
import com.yourbank.persistence.UserRepository;
import com.yourbank.service.UserProfileService;
import com.yourbank.service.UserService;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    public User add(@NotNull User user) {
        if (user != null && getByEmail(user.getEmail()) == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            return userRepository.saveAndFlush(user);
        }
        return null;
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

    public List<Score> getAllScores(Long ID) {
        return get(ID).getScores();
    }
}
