package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.serviceRequest.Loan;

public interface LoanRepository extends JpaRepository<Loan,Integer>{

  public Loan findByLoanNumber(int CustomerId);

}
