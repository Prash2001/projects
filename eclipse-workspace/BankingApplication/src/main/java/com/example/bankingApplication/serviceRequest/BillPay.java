package com.example.bankingApplication.serviceRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "BILLPAY")
public class BillPay {
  
  public String TypeOfBill;
  public String getTypeOfBill() {
    return TypeOfBill;
  }
  public void setTypeOfBill(String typeOfBill) {
    TypeOfBill = typeOfBill;
  }
  
  public int getBillNum() {
    return BillNum;
  }
  public void setBillNum(int billNum) {
    BillNum = billNum;
  }
  public int getAmountToPay() {
    return AmountToPay;
  }
  public void setAmountToPay(int amountToPay) {
    AmountToPay = amountToPay;
  }
  public int getTransactionId() {
    return TransactionId;
  }
  public void setTransactionId(int transactionId) {
    TransactionId = transactionId;
  }
  @Id
  @Column(name = "bill_id")
  public int BillNum;
  public int AmountToPay;
  @GeneratedValue
  public int TransactionId;

}
