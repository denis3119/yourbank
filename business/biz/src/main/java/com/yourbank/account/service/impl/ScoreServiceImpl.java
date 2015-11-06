package com.yourbank.account.service.impl;

import com.sun.istack.internal.NotNull;
import com.yourbank.account.persistence.ScoreRepository;
import com.yourbank.account.service.ScoreService;
import com.yourbank.bank.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public Score add(@NotNull Score entity) {
        return scoreRepository.saveAndFlush(entity);
    }

    public void delete(@NotNull Score entity) {
        scoreRepository.delete(entity);
    }

    public Score get(long ID) {
        return scoreRepository.getOne(ID);
    }

    public Score update(Score entity) {
        return scoreRepository.saveAndFlush(entity);
    }
}
