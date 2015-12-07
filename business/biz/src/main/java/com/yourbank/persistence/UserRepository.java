package com.yourbank.persistence;

import com.yourbank.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 11/2/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByName(@Param("name") String name);

    User getByEmail(@Param("email") String email);
}