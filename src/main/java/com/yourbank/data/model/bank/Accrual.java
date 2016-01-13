package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by admin on 11.01.2016.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Accrual extends AbstractExpiringEntity {
    private double sum; // основной долг
    private double percent; //сумма по процентам
    private double fine;//пеня
    private Date month;//за какой месяц
    private boolean paid;//оплачено или нет

    public double allSum() {
        return sum + percent + fine;
    }
}
