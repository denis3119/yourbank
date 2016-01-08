package com.yourbank.tests;

import com.yourbank.config.Application;
import com.yourbank.util.UserUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by admin on 06.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserUtilTest {
    @Test
    public void hashTest() {
        String password = "123";
        assertNotNull(UserUtil.getPasswordHash(password));
    }
}
