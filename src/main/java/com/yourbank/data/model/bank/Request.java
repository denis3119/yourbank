package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.service.status.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Request extends AbstractExpiringEntity {

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;
    private String phoneNumber;
    private String firstName;
    private String target;
    private String lastName;
    private String patronymic;
    private String email;
    private int period; // месяцы
    @ManyToOne(fetch = FetchType.EAGER)
    private Credit credit;
    private double income; //доходы за 3 месяца

    public Request(String phoneNumber, String firstName, String target,
                   String lastName, String patronymic, Credit credit, String email) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.target = target;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.credit = credit;
        this.email = email;
    }
}
