package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Payment;
import com.yourbank.data.model.user.UserCredit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 11.01.2016.
 */
@Controller
@RequestMapping(value = "/score/")
public class PaymentController {

    @ResponseBody
    @RequestMapping(value = "/pay/", method = RequestMethod.POST)
    public void creditPay(UserCredit userCredit, Payment payment){

    }

}
