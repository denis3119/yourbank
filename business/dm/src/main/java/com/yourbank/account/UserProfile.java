package com.yourbank.account;

import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author admin.
 */
@Entity
public class UserProfile extends AbstractExpiringEntity {

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthday;

    private String personalNumber;

    private String passportNumber;
    @OneToOne
    private User user;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
