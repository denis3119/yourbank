package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author admin.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserProfile extends AbstractExpiringEntity {

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String patronymic;

    @Column
    private Date birthday;

    @Column(length = 50)
    private String personalNumber;

    @Column(length = 50)
    private String passportNumber;

    @OneToOne
    private User user;

    @OneToMany
    private List<Credit> credits;

    @OneToMany
    private List<Score> scores;
}
