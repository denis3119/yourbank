package com.yourbank.data.model.bank;


import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Credit extends AbstractExpiringEntity implements Cloneable {

    private String description;

    private boolean showOnlyForUser;

    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    @OneToOne
    private Score score;

    private String name;

    private long minSum;

    private long maxSum;

    private double percent;

    @ManyToMany
    private List<CreditType> creditTypes;

    public Credit clone() throws CloneNotSupportedException {
        return (Credit) super.clone();
    }

    public enum CurrencyCode {
        BLR, EUR, USD
    }
}
