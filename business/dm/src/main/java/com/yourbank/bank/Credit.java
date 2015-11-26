package com.yourbank.bank;

import com.yourbank.User;
import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;


@Entity
public class Credit extends AbstractExpiringEntity {

    private String description;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Request> requests;

    private Currency currency;

    @OneToOne
    private Score score;

    private String name;

    private long maxSum;

    private double percent;

    public List<CreditType> getCreditTypes() {
        return creditTypes;
    }

    public void setCreditTypes(List<CreditType> creditTypes) {
        this.creditTypes = creditTypes;
    }

    @ManyToMany
    private List<CreditType> creditTypes;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(long maxSumm) {
        this.maxSum = maxSumm;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

}
