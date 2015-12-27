package com.yourbank.data.repository;

import com.yourbank.data.config.repository.EntityRepository;
import com.yourbank.data.model.bank.Request;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 11/6/2015.
 */
@Repository
public interface RequestRepository extends EntityRepository<Request> {
    Request getByName(String name);
}
