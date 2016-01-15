package com.yourbank.data.repository;

import com.yourbank.data.model.log.ScoreLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladok on 05.01.2016.
 */
@Repository
public interface ScoreLogRepository extends JpaRepository<ScoreLog, Long> {
}
