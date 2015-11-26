package com.yourbank.bank;

import com.yourbank.common.AbstractExpiringEntity;


import javax.persistence.*;
import java.util.Date;

/**
 * @author admin.
 */
@Entity
public class Request extends AbstractExpiringEntity {

    private boolean aproved;

    private String phoneNumber;

    private String firstName;

    private String target;

    private Date created;

    private String lastName;

    private String patronymic;

    private Integer period; // месяцы

    @ManyToOne
    private Credit credit;

    public boolean isAproved() {
        return aproved;
    }

    public void setAproved(boolean aprove) {
        this.aproved = aprove;
    }

    public Request() {
    }

    public Request(String phoneNumber, String firstName, String target, Date period,
                   String lastName, String patronymic, Credit credit) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.target = target;
        this.created = period;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.credit = credit;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

}
