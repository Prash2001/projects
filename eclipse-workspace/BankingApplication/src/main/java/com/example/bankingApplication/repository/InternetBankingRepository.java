package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.serviceRequest.InternetBanking;
import com.example.bankingApplication.serviceRequest.OnlineTransaction;

public interface InternetBankingRepository extends JpaRepository<InternetBanking, OnlineTransaction> {
  public InternetBanking findByOnlineTransaction(OnlineTransaction onlineTransaction);
}
