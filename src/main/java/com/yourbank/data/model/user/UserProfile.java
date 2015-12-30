package com.yourbank.data.model.user;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

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

    @OneToOne
    private User user;
}
