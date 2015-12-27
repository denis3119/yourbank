package com.yourbank.service.bank;


import com.yourbank.data.model.bank.Score;
import java.util.List;

/**
 * @author admin.
 */
public interface ScoreService {
    List<Score> update(Score... scores);

    Score getByName(String name);
}
