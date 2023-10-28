package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.customerRequest.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

}
