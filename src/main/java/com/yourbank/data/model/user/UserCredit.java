package com.yourbank.data.model.user;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Credit;
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
public class UserCredit extends Credit {

    @ManyToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Accrual> accruals = new ArrayList<>();
    private int term; // окончание
    private double sum;
    private boolean paid;

    public UserCredit(Credit credit, User user, double sum, int term) {
        setDescription(credit.getDescription());
        setShowOnlyForUser(credit.isShowOnlyForUser());
        setCreditTypes(credit.getCreditTypes());
        setCurrency(credit.getCurrency());
        setMaxSum(credit.getMaxSum());
        setMinSum(credit.getMinSum());
        setName(credit.getName());
        setPercent(credit.getPercent());
        this.user = user;
        this.sum = sum;
        this.term = term;
    }
}
