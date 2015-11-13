package com.yourbank.bank;

import com.yourbank.common.AbstractExpiringEntity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author admin.
 */
@Entity
public class Request extends AbstractExpiringEntity {
    private String phoneNumber;
    private String firstName;
    private String target;
    private Date period;
    private String lastName;
    private String patronymic;
    @ManyToOne
    private Credit credit;


    public Request() {

    }

    public Request(String phoneNumber, String firstName, String target, Date period,
                   String lastName, String patronymic, Credit credit) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.target = target;
        this.period = period;
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

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
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

}
