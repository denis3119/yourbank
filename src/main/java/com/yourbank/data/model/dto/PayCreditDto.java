package com.yourbank.data.model.dto;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.user.UserCredit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by admin on 15.01.2016.
 */
@NoArgsConstructor
@Getter
@Setter
public class PayCreditDto {
    private UserCredit credit;
    private Accrual accrual;
    private double sum;
}
