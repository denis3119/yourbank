package com.yourbank.bankLogic;

import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.user.User;
import com.yourbank.service.bank.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 12.12.2015.
 */

public class ScoreUtil {

    @Autowired
    ScoreService scoreService;

    private boolean notValidated(Score fromScore, Score toScore) {
        return validateScore(fromScore) || validateScore(toScore);
    }

    @org.jetbrains.annotations.Contract("null -> true")
    private boolean validateScore(Score fromScore) {
        return fromScore == null || fromScore.getValue() <= 0;
    }

    public Score downValue(Score score, double value) {
        value = Math.abs(value);
        return editValue(score, -value);
    }

    public synchronized State transfer(Score fromScore, Score toScore, User user, double value) {
        if (notValidated(fromScore, toScore)) return State.FAIL;
        fromScore = downValue(fromScore, value);
        if (fromScore.getValue() < value) {
            return State.FAIL;
        }
        toScore = upValue(toScore, value);
        scoreService.update(fromScore, toScore);
        return State.OK;
    }

    public Score upValue(Score score, double value) {
        value = Math.abs(value);
        return editValue(score, value);
    }

    private Score editValue(Score score, double value) {
        score.setValue(score.getValue() + value);
        return score;
    }

    public enum State {
        OK, FAIL;
    }
}
