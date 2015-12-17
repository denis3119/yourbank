package com.yourbank.service.bank;


import com.yourbank.data.model.bank.Credit;
import java.util.Currency;
import java.util.Map;

/**
 * Created by admin on 11/6/2015.
 */
public interface CreditService {
    Credit getByCurrency(Currency currency);

    Map<String, String> getMapAll();
}
