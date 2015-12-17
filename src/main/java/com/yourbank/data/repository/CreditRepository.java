package com.yourbank.data.repository;

import com.yourbank.data.config.repository.EntityRepository;
import com.yourbank.data.model.bank.Credit;
import java.util.Currency;
import org.springframework.stereotype.Repository;

/**
 * @author admin.
 */
@Repository
public interface CreditRepository extends EntityRepository<Credit> {

    Credit getByCurrency(Currency currency);
}
