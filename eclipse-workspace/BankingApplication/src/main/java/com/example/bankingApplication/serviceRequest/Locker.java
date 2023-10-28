package com.example.bankingApplication.serviceRequest;

import java.io.Serializable;
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
@Table(name = "LOCKER")
public class Locker implements Serializable{
  public int getLockerNum() {
    return lockerNum;
  }
  public void setLockerNum(int lockerNum) {
    this.lockerNum = lockerNum;
  }
  public int getCustomerAccNum() {
    return customerAccNum;
  }
  public void setCustomerAccNum(int customerAccNum) {
    this.customerAccNum = customerAccNum;
  }
  public int getBranchNum() {
    return branchNum;
  }
  public void setBranchNum(int branchNum) {
    this.branchNum = branchNum;
  }
  @Id
  @Column(name = "locker_id")
  public int lockerNum;
  public int customerAccNum;
  public int branchNum;
}
