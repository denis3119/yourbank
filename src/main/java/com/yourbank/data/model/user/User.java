package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User extends AbstractExpiringEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(unique = true)
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRole = new HashSet<UserRole>(0);
    @OneToMany
    private List<Credit> credits;
    @OneToMany
    private List<Score> scores;
    @OneToOne
    private UserProfile userProfile;

    public User() {

    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

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

