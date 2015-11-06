package com.yourbank.bank;

import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.OneToOne;

/**
 * Created by admin on 11/2/2015.
 */
public class Request extends AbstractExpiringEntity {
    private String phoneNumber;
    private String firstName;

    private String lastName;

    private String patronymic;

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

    private Credit credit;
}
