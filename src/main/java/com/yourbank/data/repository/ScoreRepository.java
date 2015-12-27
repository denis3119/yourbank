package com.yourbank.data.repository;

import com.yourbank.data.config.repository.EntityRepository;
import com.yourbank.data.model.bank.Score;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author admin.
 */
@Repository
public interface ScoreRepository extends EntityRepository<Score> {

    Score getByName(@Param("name") String name);
}
