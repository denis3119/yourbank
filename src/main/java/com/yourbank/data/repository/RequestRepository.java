package com.yourbank.data.repository;

import com.yourbank.data.config.repository.EntityRepository;
import com.yourbank.data.model.bank.Request;
import org.springframework.stereotype.Repository;

/**
 * @author admin.
 */
@Repository
public interface RequestRepository extends EntityRepository<Request> {
}
