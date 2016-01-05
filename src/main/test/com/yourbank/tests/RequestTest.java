package com.yourbank.tests;

import com.yourbank.config.Application;
import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.service.bank.RequestService;
import com.yourbank.service.user.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by admin on 26.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RequestTest {
    Request testRequest = new Request("test", "123", "testRequest", "target", "testlastname", "tt", null, "denis3119@gmail.com");

    @Autowired
    RequestService requestService;
    @Autowired
    UserService userService;

    @Test
    public void createUserFromRequest() {
        Request request = createRequest();
        assertNotNull(request);
        request = requestService.approve(request);
        assertTrue(request.isApproved());
        User user2 = requestService.createUserFromRequest(request);
        User user = userService.getByName(testRequest.getFirstName());
        assertNotNull(user);
    }

    @Test
    public void create() {
        Request request = createRequest();
        assertNotNull(request);
    }

    private Request createRequest() {
        return requestService.add(testRequest);
    }

    @Test
    public void delete() {
        createRequest();
        deleteAllTestRequest();
        assertNull(requestService.getByName(testRequest.getName()));
    }


    @After
    public void deleteAllTestRequest() {
        deleteTestRequest();
        deleteUser();
    }

    private void deleteUser() {
        User user = userService.getByName(testRequest.getFirstName());
        if (user != null) {
            userService.delete(user);
        }
    }

    private void deleteTestRequest() {
        Request request = requestService.getByName(testRequest.getName());
        if (request != null) {
            requestService.delete(request);
        }
    }
}
