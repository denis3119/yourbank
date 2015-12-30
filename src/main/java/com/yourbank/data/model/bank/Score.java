package com.yourbank.data.model.bank;


import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Score extends AbstractExpiringEntity {

    @Column(unique = true)
    private String name;
    private double value;
    @ManyToOne
    private User user;
    @OneToOne
    private Credit credit;
    @ManyToMany
    private List<ScoreType> scoreTypes;
    private Currency currency;

    public Score(String name, double value) {
        this.name = name;
        this.value = value;
    }

}
