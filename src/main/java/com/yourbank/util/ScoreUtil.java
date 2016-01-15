package com.yourbank.util;

import com.sun.scenario.effect.Effect;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.log.ScoreLog;
import com.yourbank.data.model.user.User;
import com.yourbank.service.bank.ScoreService;
import com.yourbank.service.log.ScoreLogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 12.12.2015.
 */

public class ScoreUtil {
    @Autowired
    static ScoreLogService scoreLogService;
    private static boolean notValidated(Score fromScore, Score toScore) {
        return validateScore(fromScore) || validateScore(toScore);
    }

    @org.jetbrains.annotations.Contract("null -> true")
    private static boolean validateScore(Score fromScore) {
        return fromScore == null || fromScore.getValue() <= 0;
    }

    public static Score downValue(Score score, double value) {
        value = Math.abs(value);
        return editValue(score, -value);
    }

    private static boolean hasPermissions(User user, Score score) {
        if (score == null || user == null) {
            return false;
        }
        if (score.getUser().getEmail().equals(user.getEmail())) {
            return true;
        }
        return false;
    }

    public static synchronized State transfer(Score fromScore, Score toScore, User user, double value, ScoreService scoreService) {
        Action actionType = Action.TRANSFER;
        ScoreLog scoreLog ;
        State state = State.FAIL;
        fromScore = downValue(fromScore, value);
        try {
            if (!hasPermissions(user, fromScore)) {
                state = State.PERMISSION_ERROR;
            } else if (notValidated(fromScore, toScore)) {
                state = State.VALUE_ERROR;
            } else if (fromScore.getValue() < value) {
                state = State.VALUE_ERROR;
            } else
            {
                toScore = upValue(toScore, value);
                scoreService.update(fromScore, toScore);
                state =  State.OK;
            }

        } catch (Exception e) {
            state =  State.FAIL;
        }
        scoreLog = new ScoreLog(state,actionType,fromScore,toScore,value,user);
        scoreLogService.add(scoreLog);

        return state;
    }

    public static Score upValue(Score score, double value) {
        value = Math.abs(value);
        return editValue(score, value);
    }

    private static Score editValue(Score score, double value) {
        score.setValue(score.getValue() + value);
        return score;
    }

    public enum State {
        OK, FAIL, VALUE_ERROR, PERMISSION_ERROR;
    }

    public enum Action {
        TRANSFER;
    }
}
