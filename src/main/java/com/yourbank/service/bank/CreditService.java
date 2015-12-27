package com.yourbank.service.bank;


import com.yourbank.data.model.bank.Credit;
import java.util.Currency;
import java.util.List;
import java.util.Map;

/**
 * @author admin.
 */
public interface CreditService {

    Credit add(Credit credit);

    Credit get(long creditID);

    Credit getByCurrency(Currency currency);

    Map<String, String> getMapAll();

    List<Credit> getAll();
}
