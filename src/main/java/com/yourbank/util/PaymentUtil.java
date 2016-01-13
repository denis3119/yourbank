package com.yourbank.util;

import com.yourbank.data.model.bank.Accrual;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 13.01.2016.
 */
public class PaymentUtil {
    public static List<Accrual> getNotPaid(List<Accrual> accruals) {
       return accruals.stream().filter(accrual -> !accrual.isPaid()).collect(Collectors.toList());
    }
}
