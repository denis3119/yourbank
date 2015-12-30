package com.yourbank.data.model.bank;



import com.yourbank.data.model.user.User;
import com.yourbank.data.model.common.AbstractExpiringEntity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Credit extends AbstractExpiringEntity {

    private String description;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Request> requests;

    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    @OneToOne
    private Score score;

    private String name;

    private long minSum;
    
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

    public CurrencyCode getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyCode currency) {
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

    public long getMinSum() {
        return minSum;
    }

    public void setMinSum(long minSum) {
        this.minSum = minSum;
    }

    public enum CurrencyCode {
        BLR, EUR, USD
    }
}
