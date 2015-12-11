package com.yourbank.data.service;


import com.yourbank.data.model.bank.Credit;

import java.util.Currency;
import java.util.Map;

/**
 * Created by admin on 11/6/2015.
 */
public interface CreditService extends Service<Credit> {
    Credit getByCurrency(Currency currency);

    Map<String, String> getMapAll();
}
