package com.yourbank;

import com.yourbank.common.AbstractEntity;
import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.*;

/**
 * @author admin.
 */
@Entity
public class UserRole extends AbstractExpiringEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private String role;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }


    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}