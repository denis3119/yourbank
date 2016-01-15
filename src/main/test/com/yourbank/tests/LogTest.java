package com.yourbank.tests;


import com.yourbank.config.Application;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.log.ScoreLog;
import com.yourbank.data.model.user.User;
import com.yourbank.service.bank.ScoreService;
import com.yourbank.service.log.ScoreLogService;
import com.yourbank.service.user.UserService;
import com.yourbank.util.ScoreUtil;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Vladok on 05.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class LogTest {
    @Autowired
    ScoreService scoreService;
    private static final String TEST_NAME = "testUser";
    private static final String TEST_PASSWORD = "password";
    private static final String TEST_EMAIL = "testUSer@test.com";
    //private User testUser = new User(TEST_NAME, TEST_PASSWORD, TEST_EMAIL);
    private double summ = 10000;

    private Score scoreFrom = new Score("scoreFromName", 150000.99);
    private Score scoreTo = new Score("scoreToName", 0);

    @Autowired
    private UserService userService;
    @Autowired
    private ScoreLogService scoreLogService;

    @Test
    public void scoreLogCreate() {
        ScoreLog scoreLog = new ScoreLog();
        scoreLog.setUser(createAndGetUser());
        scoreLog.setActionType(ScoreUtil.Action.TRANSFER);
        scoreLog.setState(ScoreUtil.State.OK);
        scoreLog.setSumm(100000.99);
        scoreLog.setScoreFrom(scoreFrom);
        scoreLog.setScoreTo(scoreTo);

    }

    @Test
    public void transferTest() {
        ScoreUtil.transfer(scoreFrom, scoreTo, createAndGetUser(), summ, scoreService);
    }

    private User createAndGetUser() {
        User user = new User(TEST_NAME, TEST_PASSWORD, TEST_EMAIL);
        userService.add(user);

        return user;
    }
}

 //   @After
//    public void deleteTestUser() {
//        deleteUserByName(TEST_NAME);
 //   }
//
//    private void deleteUserByName(String name) {
//        User user = userService.getByName(name);
//        if (user != null) {
//            userService.delete(user);
//        }
//    }
//}
