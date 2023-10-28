package com.java.bankingApplication0.customerRequest;

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

// Customer Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CUSTOMER")
public class Customer {


  // Constructor for inserting dummy data
  public Customer(int customerId, String CustomerName, int CustomerAccNum,
      String CustomerContactNum, int CustomerPancardNum, CustomerAccType accType,
      Branch CustomerBranchDetails, CreditCard CustomerCreditCard, Address CustomerAddress) {
    this.customerId = customerId;
    this.customerName = CustomerName;
    this.customerAccNum = CustomerAccNum;
    this.customerBranchDetails = CustomerBranchDetails;
    this.accType = accType;
    this.customerContactNum = CustomerContactNum;
    this.customerCreditCard = CustomerCreditCard;
    this.customerPancardNum = CustomerPancardNum;
    this.customerAddress = CustomerAddress;
  }

  // Empty Constructor
  public Customer() {};


  @Id
  @Column(name = "customer_id")
  private int customerId;

  private String customerName;

  private int customerAccNum;

  // Reference of Branch entity
  @OneToOne
  @JoinColumn(name = "branch_fk", referencedColumnName = "branch_id")
  private Branch customerBranchDetails;

  public static enum CustomerAccType {
    Saving, Salary, Fixed_Deposit;
  }

  private CustomerAccType accType;

  private String customerContactNum;

  // Reference of Credit Card entity
  @OneToOne
  @JoinColumn(name = "card_fk", referencedColumnName = "card_id")
  private CreditCard customerCreditCard;

  private int customerPancardNum;

  // Reference of Address entity
  @OneToOne
  @JoinColumn(name = "address_fk", referencedColumnName = "address_id")
  private Address customerAddress;

  // Getter and Setters
  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public int getCustomerAccNum() {
    return this.customerAccNum;
  }

  public void setCustomerAccNum(int customerAccNum) {
    this.customerAccNum = customerAccNum;
  }

  public Branch getCustomerBranchDetails() {
    return this.customerBranchDetails;
  }

  public void setCustomerBranchDetails(Branch customerBranchDetails) {
    this.customerBranchDetails = customerBranchDetails;
  }

  public String getCustomerContactNum() {
    return this.customerContactNum;
  }

  public void setCustomerContactNum(String customerContactNum) {
    this.customerContactNum = customerContactNum;
  }

  public int getCustomerPancardNum() {
    return this.customerPancardNum;
  }

  public void setCustomerPancardNum(int customerPancardNum) {
    this.customerPancardNum = customerPancardNum;
  }

  public Address getCustomerAddress() {
    return this.customerAddress;
  }

  public void setCustomerAddress(Address customerAddress) {
    this.customerAddress = customerAddress;
  }

  public CustomerAccType getAccType() {
    return accType;
  }

  public void setAccType(CustomerAccType accType) {
    this.accType = accType;
  }

  public CreditCard getCustomerCreditCard() {
    return customerCreditCard;
  }

  public void setCustomerCreditCard(CreditCard customerCreditCard) {
    this.customerCreditCard = customerCreditCard;
  }

}
