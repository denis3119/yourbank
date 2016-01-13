package com.yourbank.data.repository;

import com.yourbank.data.model.bank.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 13.01.2016.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
