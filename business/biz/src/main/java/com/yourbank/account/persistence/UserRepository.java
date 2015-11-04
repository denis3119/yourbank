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
      public Object save(User user);

    List<User> findAll();

    List<User> findAll(Sort sort);

    List<User> findAll(Iterable<Long> longs);

    void flush();

    void deleteInBatch(Iterable<User> entities);

    void deleteAllInBatch();

    User getOne(Long aLong);

    Page<User> findAll(Pageable pageable);

    User findOne(Long aLong);

    boolean exists(Long aLong);

    long count();

    void delete(Long aLong);

    void delete(User user);

    void delete(Iterable<? extends User> iterable);

    void deleteAll();
}
