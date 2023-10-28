package com.java.bankingApplication0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.bankingApplication0.customerRequest.CreditCard;
// Repository level of Credit Card Entity
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
  public CreditCard findByCardNumber(String cardNumber);
}
