package com.example.bankingApplication.serviceRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "LOAN")
public class Loan {
  public Loan(int loanNumber, int customerId, int loanAmount) {
    this.customerId = customerId;
    this.loanAmount = loanAmount;
    this.loanNumber = loanNumber;
  }
  public Loan() {
    
  }
  public int getLoanNumber() {
    return loanNumber;
  }
  public void setLoanNumber(int loanNumber) {
    this.loanNumber = loanNumber;
  }
  public int getCustomerId() {
    return customerId;
  }
  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }
  public int getLoanAmount() {
    return loanAmount;
  }
  public void setLoanAmount(int loanAmount) {
    this.loanAmount = loanAmount;
  }
  @Id
  @Column(name = "loan_id")
  public int loanNumber;
  public int customerId;
  public int loanAmount;
}
