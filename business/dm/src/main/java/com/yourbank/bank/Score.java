package com.yourbank.bank;

import com.yourbank.account.User;
import com.yourbank.common.AbstractExpiringEntity;

import java.util.Currency;

/**
 * Created by admin on 11/3/2015.
 */
public class Score extends AbstractExpiringEntity {
    private Double value;
    private User user;
    private Currency currency;
}
