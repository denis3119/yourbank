package com.yourbank.data.model.user;


import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserRole extends AbstractExpiringEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    @Column(unique = true)
    private String role;

    public UserRole(Set<User> users, String role) {
        this.users = users;
        this.role = role;
    }

    public UserRole(User user, String role) {
        Set<User> users = new HashSet<>();
        users.add(user);
        this.users = users;
        this.role = role;
    }
}