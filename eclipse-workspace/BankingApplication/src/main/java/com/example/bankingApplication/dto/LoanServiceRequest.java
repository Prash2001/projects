package com.example.bankingApplication.dto;

import com.example.bankingApplication.serviceRequest.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanServiceRequest {
  public Loan customloaner;
}
