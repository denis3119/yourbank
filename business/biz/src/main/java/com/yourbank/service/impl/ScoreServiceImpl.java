package com.yourbank.service.impl;

import com.yourbank.User;
import com.yourbank.persistence.ScoreRepository;
import com.yourbank.service.ScoreService;
import com.yourbank.bank.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public Score add(Score entity) {
        return scoreRepository.saveAndFlush(entity);
    }

    public void delete(Score entity) {
        scoreRepository.delete(entity);
    }

    public Score get(long ID) {
        return scoreRepository.getOne(ID);
    }

    public Score update(Score entity) {
        return scoreRepository.saveAndFlush(entity);
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }
}
