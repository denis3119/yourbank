package com.yourbank.service.bank;


import com.yourbank.data.model.bank.Score;
import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */

public interface ScoreService {
    List<Score> update(Score... scores);
}
