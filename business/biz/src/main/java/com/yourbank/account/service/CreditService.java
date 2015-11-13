package com.yourbank.account.service;

import com.yourbank.bank.Credit;
import org.springframework.stereotype.Service;

import java.util.Currency;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public interface CreditService extends AbstractService<Credit> {
    Credit getByCurrency(Currency currency);
}
