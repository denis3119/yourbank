package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09.01.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserCredit extends AbstractExpiringEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private Credit.CurrencyCode currency;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Score score;

    private String name;

    private double percent;
    @ManyToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Accrual> accruals = new ArrayList<>();
    private int term; // окончание
    private double sum;
    private boolean paid;
}
