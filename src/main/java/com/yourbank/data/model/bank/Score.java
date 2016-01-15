package com.yourbank.data.model.bank;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.User;
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
public class Score extends AbstractExpiringEntity {

    private String name;

    private double value;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private UserProfile userProfile;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ScoreType scoreTypes;

    @Enumerated(EnumType.STRING)
    private Credit.CurrencyCode currency = Credit.CurrencyCode.BLR;

    public Score(String name, double value) {
        this.name = name;
        this.value = value;
    }

}
