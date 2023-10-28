package com.example.bankingApplication.serviceRequest;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="INTERNETBANKING")
public class InternetBanking implements Serializable {
  @Id
  @OneToOne//(targetEntity = OnlineTransaction.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_fk", referencedColumnName = "transaction_id")
  public OnlineTransaction onlinetransaction;
  
  public OnlineTransaction getTonlinetransaction() {
    return onlinetransaction;
  }

  public void setTonlinetransaction(OnlineTransaction onlinetransaction) {
    this.onlinetransaction = onlinetransaction;
  }

  public BillPay getBillPay() {
    return billPay;
  }

  public void setBillPay(BillPay billPay) {
    this.billPay = billPay;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  @OneToOne//(targetEntity = BillPay.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "bill_fk", referencedColumnName = "bill_id")
  public BillPay billPay;
  
  @OneToOne//(targetEntity = Insurance.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "insurance_fk", referencedColumnName = "insurance_id")
  public Insurance insurance;
}
