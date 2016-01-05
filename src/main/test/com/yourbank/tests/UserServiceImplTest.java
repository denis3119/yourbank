package com.yourbank.tests;

import com.yourbank.config.Application;
import com.yourbank.data.model.user.User;
import com.yourbank.service.user.UserService;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by admin on 14.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserServiceImplTest {
    private static final String TEST_NAME = "testUser";
    private static final String TEST_NAME_SECOND = "testUser2";
    private static final String TEST_PASSWORD = "password";
    private static final String TEST_EMAIL = "testUSer@test.com";
    @Autowired
    UserService userService;

    @Test
    public void getAll() {
        assertTrue(userService.getAll() != null);
    }

    @Test
    public void createUser() {
        User user = createAndGetUser();
        assertEquals(user.getName(), userService.getByName(TEST_NAME).getName());
    }

    @NotNull
    private User createAndGetUser() {
        User user = new User(TEST_NAME, TEST_PASSWORD, TEST_EMAIL);
        userService.add(user);
        return user;
    }

    @Test
    public void delete() {
        User user = createAndGetUser();
        userService.delete(user);
        assertEquals(userService.getByName(TEST_NAME), null);
    }

    @Test
    public void updateUser() {
        deleteTestUser();
        User user = createAndGetUser();
        user.setName(TEST_NAME_SECOND);
        userService.update(user);
        assertEquals(user.getName(), userService.getByName(TEST_NAME_SECOND).getName());
    }

    @After
    public void deleteTestUser() {
        deleteUserByName(TEST_NAME);
        deleteUserByName(TEST_NAME_SECOND);
    }

    private void deleteUserByName(String name) {
        User user = userService.getByName(name);
        if (user != null) {
            userService.delete(user);
        }
    }
}