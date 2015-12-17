package com.yourbank.data.repository;

import com.yourbank.data.config.repository.EntityRepository;
import com.yourbank.data.model.user.User;

/**
 * @author Yugov Alexandr.
 */
public interface UserRepository extends EntityRepository<User> {

    User getByUsername(String username);

    User getByEmail(String email);
}
