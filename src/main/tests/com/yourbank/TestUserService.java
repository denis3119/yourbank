package com.yourbank;

import com.yourbank.config.Application;
import com.yourbank.data.model.user.User;
import com.yourbank.data.repository.UserRepository;
import com.yourbank.data.service.UserService;
import com.yourbank.data.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

/**
 * Created by admin on 11.12.2015.
 * //
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TestUserService {

    //  @Autowired
    // private UserService userService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void add() {
        User user = new User("test", "test", "test@test.by");
        userRepository.saveAndFlush(user);
        String name = userRepository.getByName("test").getName();
        assertTrue(true);
    }


    @After
    public void deleteUserTest() {
        User user = userRepository.getByName("test");
        if (user != null) {
            userRepository.delete(user);
        }
    }

    @Configuration
    static class UserServiceTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }
}
