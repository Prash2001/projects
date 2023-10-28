package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.serviceRequest.BillPay;

public interface BillPayRepository extends JpaRepository<BillPay, Integer> {
  public BillPay findByBillNum(int billNum);
}
