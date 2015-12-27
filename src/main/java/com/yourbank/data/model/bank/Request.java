package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author admin.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Request extends AbstractExpiringEntity {

    @Column(unique = true)
    private String name;
    private boolean approved = false;
    private String phoneNumber;

    private String firstName;

    private String target;

    private String lastName;

    private String patronymic;

    private Integer monthPeriod; // месяцы

    @ManyToOne(fetch = FetchType.EAGER)
    private Credit credit;

    public Request() {
    }

    public Request(String name, String phoneNumber, String firstName, String target,
                   String lastName, String patronymic, Credit credit, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.target = target;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.credit = credit;
        this.email = email;
    }
}
