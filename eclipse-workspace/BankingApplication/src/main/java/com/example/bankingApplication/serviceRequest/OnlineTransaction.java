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
@Table(name = "ONLINETRANSACTION")
public class OnlineTransaction {
  public int getCustomerAccNum() {
    return customerAccNum;
  }
  public void setCustomerAccNum(int customerAccNum) {
    this.customerAccNum = customerAccNum;
  }
  public int getBenificiaryAccNum() {
    return BenificiaryAccNum;
  }
  public void setBenificiaryAccNum(int benificiaryAccNum) {
    BenificiaryAccNum = benificiaryAccNum;
  }
  public String getISFCCode() {
    return ISFCCode;
  }
  public void setISFCCode(String iSFCCode) {
    ISFCCode = iSFCCode;
  }
  public int getAmountToTransfer() {
    return AmountToTransfer;
  }
  public void setAmountToTransfer(int amountToTransfer) {
    AmountToTransfer = amountToTransfer;
  }
  @Id
  @Column(name = "transaction_id")
  public int customerAccNum;
  public int BenificiaryAccNum;
  public String ISFCCode;
  public int AmountToTransfer;

}
