package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.service.status.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by admin on 09.01.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Payment extends AbstractExpiringEntity {
    @ManyToOne
    private User user;
    @ManyToOne
    private UserCredit userCredit;

    private double value;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
