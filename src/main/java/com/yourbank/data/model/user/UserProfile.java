package com.yourbank.data.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class UserProfile extends AbstractExpiringEntity {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String patronymic;
    @NonNull
    private Date birthday;
    @NonNull
    private String personalNumber;
    @NonNull
    private String passportNumber;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Score.class)
    @NonNull
    private Score score;

    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private User user;

    @OneToMany
    private List<UserCredit> userCredits = new ArrayList<>();
}
