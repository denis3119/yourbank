package com.yourbank.data.service.impl;

import com.yourbank.data.model.bank.Score;
import com.yourbank.data.repository.ScoreRepository;
import com.yourbank.data.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<Score> update(List<Score> entities) {
        List<Score> result = new ArrayList<>();
        for (Score score : entities) {
            result.add(update(score));
        }
        return result;
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public List<Score> update(Score... scores) {
        List<Score> scoreList = new ArrayList<>();
        Collections.addAll(scoreList, scores);
        return update(scoreList);
    }
}
