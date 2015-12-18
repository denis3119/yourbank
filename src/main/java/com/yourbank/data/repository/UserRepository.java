package com.yourbank.data.repository;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Yugov Alexandr.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User getByName(@Param("name") String name);
    User getByEmail(@Param("email") String email);
}
