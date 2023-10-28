package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.serviceRequest.OnlineTransaction;

public interface OnlineTransactionRepository extends JpaRepository<OnlineTransaction, Integer> {
  public OnlineTransaction findByCustomerAccNum(int customerAccNum);

}
