package com.yourbank.persistence;

import com.yourbank.bank.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 11/6/2015.
 */
@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
