package com.example.bankingApplication.customerRequest;

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
@Table(name = "CUSTOMER")
public class Customer {
  public Customer(int customerId, String CustomerName, int CustomerAccNum,
      String CustomerContactNum, int CustomerPancardNum, CustomerAccType accType,
      Branch CustomerBranchDetails, CreditCard CustomerCreditCard, Address CustomerAddress) {
    this.setCustomerId(customerId);
    this.customerName = CustomerName;
    this.customerAccNum = CustomerAccNum;
    this.customerBranchDetails = CustomerBranchDetails;
    this.accType = accType;
    this.customerContactNum = CustomerContactNum;
    this.customerCreditCard = CustomerCreditCard;
    this.customerPancardNum = CustomerPancardNum;
    this.customerAddress = CustomerAddress;
  }

  public Customer() {};


  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }


  @Id
  @Column(name = "customer_id")
  private int customerId;
  private String customerName;
  private int customerAccNum;
  @OneToOne
  @JoinColumn(name = "branch_fk", referencedColumnName = "branch_id")
  private Branch customerBranchDetails;

  private static enum CustomerAccType {
    Saving, Salary, Fixed_Deposit;
  }

  private CustomerAccType accType;
  private String customerContactNum;
  @OneToOne
  @JoinColumn(name = "card_fk", referencedColumnName = "card_id")
  private CreditCard customerCreditCard;
  private int customerPancardNum;
  @OneToOne
  @JoinColumn(name = "address_fk", referencedColumnName = "address_id")
  private Address customerAddress;

}
