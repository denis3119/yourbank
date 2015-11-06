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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
