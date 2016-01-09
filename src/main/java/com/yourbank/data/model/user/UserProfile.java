package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserProfile extends AbstractExpiringEntity {

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthday;

    private String personalNumber;

    private String passportNumber;

    @OneToMany
    private List<Score> scores;

    @OneToOne
    private User user;
}
