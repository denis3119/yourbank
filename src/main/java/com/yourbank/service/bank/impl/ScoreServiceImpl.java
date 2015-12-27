package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Score;
import com.yourbank.data.repository.ScoreRepository;
import com.yourbank.service.bank.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author admin.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public Score register(Score entity) {
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

    public List<Score> update(List<Score> entities) {
        List<Score> result = new ArrayList<>();
        for (Score score : entities) {
            result.add(update(score));
        }
        return result;
    }

    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public List<Score> update(Score... scores) {
        List<Score> scoreList = new ArrayList<>();
        Collections.addAll(scoreList, scores);
        return update(scoreList);
    }

    @Override
    public Score getByName(String name) {
        return scoreRepository.getByName(name);
    }
}
