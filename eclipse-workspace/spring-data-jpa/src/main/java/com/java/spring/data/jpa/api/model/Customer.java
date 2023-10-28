package com.java.spring.data.jpa.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table
public class Customer {
  public Customer(int CustomerId, String CustomerName, int CustomerAccNum, String profession, int age) {
    this.CustomerId = CustomerId;
    this.CustomerName = CustomerName;
    this.CustomerAccNum = CustomerAccNum;
    this.profession = profession;
    this.age = age;
  }
  public Customer() {};
  @Id
  public int CustomerId;
  public String CustomerName;
  int CustomerAccNum;
  Branch CustomerBranchDetails;
  public String profession;
  public int age;
}
