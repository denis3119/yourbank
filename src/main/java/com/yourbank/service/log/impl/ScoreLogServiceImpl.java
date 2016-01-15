package com.yourbank.service.log.impl;

import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.log.ScoreLog;
import com.yourbank.data.repository.ScoreLogRepository;
import com.yourbank.service.log.ScoreLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladok on 05.01.2016.
 */
@Service
public class ScoreLogServiceImpl implements ScoreLogService {
    @Autowired
    private ScoreLogRepository scoreLogRepository;

    @Override
    public ScoreLog add(ScoreLog entity) {
        return scoreLogRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(ScoreLog entity) {
        scoreLogRepository.delete(entity);
    }

    @Override
    public ScoreLog get(long ID) {
        return scoreLogRepository.getOne(ID);
    }

    @Override
    public ScoreLog update(ScoreLog entity) {
        return scoreLogRepository.saveAndFlush(entity);
    }

    @Override
    public List<ScoreLog> update(List<ScoreLog> entities) {

        List<ScoreLog> result = new ArrayList<>();
        for (ScoreLog score : entities) {
            result.add(update(score));
        }
        return result;
    }

    @Override
    public List<ScoreLog> getAll() {
        return scoreLogRepository.findAll();
    }
}
