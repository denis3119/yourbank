package com.yourbank.data.model.bank;


import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.UserProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;

/**
 * @author admin.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Score extends AbstractExpiringEntity {

    @Column(unique = true)
    private String name;

    private double value;

    @ManyToOne
    private UserProfile userProfile;

    @OneToOne
    private Credit credit;

    @ManyToMany
    private List<ScoreType> scoreTypes;

    public Score(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Currency currency;
}
