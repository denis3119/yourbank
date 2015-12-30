package com.yourbank.data.repository;

import com.yourbank.data.model.bank.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Currency;

/**
 * Created by admin on 11/6/2015.
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    Credit getByCurrency(Currency currency);
}
