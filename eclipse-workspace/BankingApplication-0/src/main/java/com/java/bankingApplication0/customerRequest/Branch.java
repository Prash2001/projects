package com.java.bankingApplication0.customerRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
// Branch Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="BRANCH")
public class Branch {
  public int getBranchCode() {
    return branchCode;
  }
  public void setBranchCode(int branchCode) {
    this.branchCode = branchCode;
  }
  public String getBranchName() {
    return branchName;
  }
  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }
  public String getBranchIFSCCode() {
    return branchIFSCCode;
  }
  public void setBranchIFSCCode(String branchIFSCCode) {
    this.branchIFSCCode = branchIFSCCode;
  }
  @Id
  @Column(name = "branch_id")
  private int branchCode;
  private String branchName;
  private String branchIFSCCode;
}
