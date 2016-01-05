package com.yourbank.tests;

import com.yourbank.bankLogic.ScoreUtil;
import com.yourbank.config.Application;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.user.User;
import com.yourbank.service.bank.ScoreService;
import com.yourbank.service.user.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 14.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestBankLogic {
    private static final String FROM_NAME = "first";
    private static final String TO_NAME = "second";
    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;

    @Test
    public void testTransfer() {
        Score from = scoreService.getByName(FROM_NAME);
        Score to = scoreService.getByName(TO_NAME);
        User user = new User("test", "test", "test@test.by");
        user = userService.add(user);
        from.setUser(user);
        ScoreUtil.State state = ScoreUtil.transfer(from, to, user, 50, scoreService);
        assertEquals(state, ScoreUtil.State.OK);
    }

    @Test
    public void testTransferErrorValue() {
        Score from = scoreService.getByName(FROM_NAME);
        Score to = scoreService.getByName(TO_NAME);
        User user = new User("test", "test", "test@test.by");
        from.setUser(user);
        ScoreUtil.State state = ScoreUtil.transfer(from, to, user, 500, scoreService);
        assertEquals(state, ScoreUtil.State.VALUE_ERROR);
    }

    @Test
    public void testTransferError() {
        Score from = scoreService.getByName(FROM_NAME);
        Score to = scoreService.getByName(TO_NAME);
        User user = new User("test", "test", "test@test.by");
        from.setUser(user);
        ScoreUtil.State state = ScoreUtil.transfer(from, to, user, 50, null);
        assertEquals(state, ScoreUtil.State.FAIL);
    }

    @Before
    public void createScores() {
        Score from = new Score(FROM_NAME, 100);
        Score to = new Score(TO_NAME, 50);
        scoreService.add(from);
        scoreService.add(to);
        deleteUser();
    }

    private void deleteUser() {
        User user = userService.getByName("test");
        if (user != null) {
            userService.delete(user);
        }
    }

    @After
    public void deleteScores() {
        Score from = scoreService.getByName(FROM_NAME);
        Score to = scoreService.getByName(TO_NAME);
        delete(from);
        delete(to);
    }

    private void delete(Score score) {
        if (score != null) {
            scoreService.delete(score);
        }
    }
}
