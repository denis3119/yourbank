package com.yourbank.data.repository;

import com.yourbank.data.config.repository.EntityRepository;
import com.yourbank.data.model.user.UserProfile;
import org.springframework.stereotype.Repository;

/**
 * @author admin.
 */
@Repository
public interface UserProfileRepository extends EntityRepository<UserProfile> {
}
