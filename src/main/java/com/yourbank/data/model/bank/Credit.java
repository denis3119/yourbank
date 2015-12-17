package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.User;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Credit extends AbstractExpiringEntity {

    private String description;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Request> requests;

    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    @OneToOne
    private Score score;

    private String name;

    private long minSum;
    
    private long maxSum;

    private double percent;

    public List<CreditType> getCreditTypes() {
        return creditTypes;
    }

    public void setCreditTypes(List<CreditType> creditTypes) {
        this.creditTypes = creditTypes;
    }

    @ManyToMany
    private List<CreditType> creditTypes;

    public enum CurrencyCode {
        BLR, EUR, USD
    }
}
