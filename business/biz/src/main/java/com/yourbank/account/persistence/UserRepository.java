package com.yourbank.account.persistence;

import com.yourbank.account.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 11/2/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
