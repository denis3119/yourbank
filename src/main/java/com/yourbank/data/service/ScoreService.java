package com.yourbank.data.service;


import com.yourbank.data.model.bank.Score;

import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */

public interface ScoreService extends Service<Score> {
    List<Score> update(Score... scores);
}
