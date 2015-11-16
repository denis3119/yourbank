package com.yourbank;

import com.yourbank.bank.Credit;
import com.yourbank.bank.Score;
import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User extends AbstractExpiringEntity {

    private String name;

    private String password;

    private String email;

    private String phone;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRole = new HashSet<UserRole>(0);


    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @OneToMany
    private List<Credit> credits;

    @OneToMany
    private List<Score> scores;

    @OneToOne
    private UserProfile userProfile;

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
