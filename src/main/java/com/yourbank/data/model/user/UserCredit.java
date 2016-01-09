package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by admin on 09.01.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserCredit extends AbstractExpiringEntity {
    private double summ;

    @ManyToOne
    private Credit credit;

    @OneToOne
    private Request request;
}
