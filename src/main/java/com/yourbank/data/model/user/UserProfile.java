package com.yourbank.data.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    @OneToOne
    private ZP zpList;
}
