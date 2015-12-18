package com.yourbank.service.bank;


import com.yourbank.data.model.bank.Credit;
import com.yourbank.service.common.Service;
import java.util.Currency;
import java.util.Map;

/**
 * Created by admin on 11/6/2015.
 */
public interface CreditService extends Service<Credit> {
    Credit getByCurrency(Currency currency);

    Map<String, String> getMapAll();
}
