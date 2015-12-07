package com.yourbank.service;

import com.yourbank.bank.Credit;

import java.util.Currency;
import java.util.Map;

/**
 * Created by admin on 11/6/2015.
 */
public interface CreditService extends Service<Credit> {
    Credit getByCurrency(Currency currency);

    Map<String, String> getMapAll();
}
