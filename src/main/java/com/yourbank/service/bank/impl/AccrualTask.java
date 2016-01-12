package com.yourbank.service.bank.impl;

import com.yourbank.service.bank.UserCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by admin on 11.01.2016.
 */
@Component
public class AccrualTask {
    @Autowired
    UserCreditService userCreditService;

    @Scheduled(fixedRate = 10000)
    public void execute() {
        System.err.println("task " + new Date());
        System.err.println("denis3119@gmail.com".hashCode());
        userCreditService.accruedAmounts();
        userCreditService.accrualFine();
    }
}
