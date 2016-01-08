package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractExpiringEntity {

    private boolean enabled = false;

    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRole = new HashSet<>(0);
    @OneToMany
    private List<Credit> credits;
    @OneToOne(cascade = CascadeType.REMOVE)
    private UserProfile userProfile;

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }
}

