package com.yourbank.data.model.bank;


import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Credit extends AbstractExpiringEntity implements Cloneable {

    private String description;

    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    private String name;

    private double minSum;

    private double maxSum;

    private double percent;

    public Credit clone() throws CloneNotSupportedException {
        return (Credit) super.clone();
    }

    public enum CurrencyCode {
        BLR, EUR, USD
    }
}
