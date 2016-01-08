package com.yourbank.util;

import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.user.User;
import com.yourbank.service.bank.ScoreService;

/**
 * Created by admin on 12.12.2015.
 */

public class ScoreUtil {

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
        try {
            if (!hasPermissions(user, fromScore)) {
                return State.PERMISSION_ERROR;
            }
            if (notValidated(fromScore, toScore)) {
                return State.VALUE_ERROR;
            }
            fromScore = downValue(fromScore, value);
            if (fromScore.getValue() < value) {
                return State.VALUE_ERROR;
            }
            toScore = upValue(toScore, value);
            scoreService.update(fromScore, toScore);
            return State.OK;
        } catch (Exception e) {
            return State.FAIL;
        }
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
}
