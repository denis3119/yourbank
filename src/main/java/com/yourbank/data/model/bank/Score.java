package com.yourbank.data.model.bank;


import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.UserProfile;
import java.util.Currency;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author admin.
 */
@Getter
@Setter
@Entity
public class Score extends AbstractExpiringEntity {

    private double value;

    @ManyToOne
    private UserProfile user;

    @OneToOne
    private Credit credit;

    @ManyToMany
    private List<ScoreType> scoreTypes;

    private Currency currency;
}
