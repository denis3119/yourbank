package com.yourbank.bank;

import com.yourbank.account.User;
import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;


@Entity
public class Credit extends AbstractExpiringEntity {
    private String description;
    @ManyToOne
    private User user;

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

    @OneToMany
    private List<Request> requests;

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

    private Currency currency;
    @OneToOne
    private Score score;
    private String name;

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


    public long getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(long maxSumm) {
        this.maxSum = maxSumm;
    }

    private long maxSum;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    private double percent;


}
