package com.yourbank.service.bank.impl;

import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.user.UserCredit;
import com.yourbank.data.repository.UserCreditRepository;
import com.yourbank.service.bank.UserCreditService;
import com.yourbank.service.user.UserService;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by admin on 11.01.2016.
 */
@Service
public class UserCreditServiceImpl implements UserCreditService {

    private static final int MONTH = 1;
    @Autowired
    UserCreditRepository userCreditRepository;
    @Autowired
    UserService userservice;

    @Override
    public void accruedAmounts() {
        addTestCredit();
        List<UserCredit> userCredits = userCreditRepository.findAll();
        for (UserCredit userCredit : getFilterCollect(userCredits)) {
            List<Accrual> accruals = userCredit.getAccruals();
            accruals.stream().sorted(Comparator.comparing(Accrual::getMonth));
            boolean isContinue = false;
            if (!accruals.isEmpty()) {
                for (Accrual accrual : accruals) {
                    if (getCurrentMonth() == getCurrentMonth(accrual.getMonth())) { // если в этом месяце уже начислили
                        isContinue = true;
                        break;
                    }
                }
            }
            if (isContinue) {
                continue;
            }
            Accrual accrual = new Accrual();
            accrual.setSum(getSumInMonth(userCredit));
            accrual.setPercent(getPercentSum(userCredit));
            accrual.setMonth(getCurrentDate());
            userCredit.getAccruals().add(accrual);
            userCreditRepository.saveAndFlush(userCredit);
        }
    }

    @Override
    public void accrualFine() {
        List<UserCredit> userCredits = userCreditRepository.findAll();
        for (UserCredit userCredit : getFilterCollect(userCredits)) {
            List<Accrual> accruals = new ArrayList<>();
            for (Accrual accrual : userCredit.getAccruals()) {
                if (getCurrentMonth(accrual.getMonth()) < getCurrentMonth()) {
                    accrual.setFine(getFine(accrual));
                }
                accruals.add(accrual);
            }
            userCredit.setAccruals(accruals);
            userCreditRepository.saveAndFlush(userCredit);
        }
    }

    private double getFine(Accrual accrual) {
        Date date = (Date) accrual.getMonth().clone();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        date.setTime(calendar.getTimeInMillis());
        long days = (getCurrentDate().getTime() - date.getTime()) / TimeUnit.DAYS.toMillis(1);
        return round(0.01 * (accrual.getSum() + accrual.getPercent()) * (days));
    }

    private void addTestCredit() {
        if (!userCreditRepository.findAll().isEmpty()) {
            return;
        }
        UserCredit userCredit = new UserCredit();
        userCredit.setAccruals(new ArrayList<>());
        userCredit.setPercent(0.1);
        userCredit.setSum(100);
        userCredit.setTerm(10);
        userCreditRepository.saveAndFlush(userCredit);
        userCredit = new UserCredit();
        userCredit.setAccruals(new ArrayList<>());
        userCredit.setPercent(0.4);
        userCredit.setSum(10000);
        userCredit.setTerm(36);
        userCreditRepository.saveAndFlush(userCredit);
    }

    private List<UserCredit> getFilterCollect(List<UserCredit> userCredits) {
        return userCredits.stream().filter(userCredit -> !userCredit.isPaid()).collect(Collectors.toList());
    }

    private int getCurrentMonth(Date calendar) {
        GregorianCalendar date = new GregorianCalendar();
        if (calendar != null) {
            date.setTime(calendar);
        }
        return date.get(Calendar.MONTH);
    }

    private int getCurrentMonth() {
        return getCurrentMonth(getCurrentDate());
    }

    private double getSumInMonth(UserCredit userCredit) {
        double sum = userCredit.getSum() / userCredit.getTerm();
        return round(sum);
    }

    @Contract(pure = true)
    private double round(double sum) {
        sum *= 100;
        sum = Math.round(sum);
        sum = (int) sum;
        return sum / 100;
    }

    private double getPercentSum(UserCredit userCredit) {
        return round(userCredit.getSum() * (userCredit.getPercent() / 12));
    }

    private Date getCurrentDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + MONTH);
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());
        return date;
    }
}
