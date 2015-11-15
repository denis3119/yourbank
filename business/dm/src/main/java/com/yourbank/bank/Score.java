package com.yourbank.bank;

import com.yourbank.User;
import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Currency;

/**
 * @author admin.
 */
@Entity
public class Score extends AbstractExpiringEntity {

    private Double value;

    @ManyToOne
    private User user;

    @OneToOne
    private Credit credit;

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

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
