package com.yourbank.data.repository;

import com.yourbank.data.model.bank.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Currency;
import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query
    Credit getByCurrency(Currency currency);
    @Query
    List<Credit> getByShowOnlyForUserTrue();
}
