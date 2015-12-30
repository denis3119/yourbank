package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author admin.
 */
@Entity
public class Request extends AbstractExpiringEntity {

    @Column(unique = true)
    private String name;
    private boolean approved = false;
    private String phoneNumber;
    private String firstName;
    private String target;
    private String lastName;
    private String patronymic;
    private String email;
    private Integer period; // месяцы
    @ManyToOne(fetch = FetchType.EAGER)
    private Credit credit;

    public Request() {
    }

    public Request(String name, String phoneNumber, String firstName, String target,
                   String lastName, String patronymic, Credit credit, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.target = target;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.credit = credit;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean aprove) {
        this.approved = aprove;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
