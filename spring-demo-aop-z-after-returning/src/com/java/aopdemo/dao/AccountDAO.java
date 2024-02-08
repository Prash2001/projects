package com.java.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.java.aopdemo.Account;

@Component
public class AccountDAO {
  private String name;
  private String serviceCode;
  
 public String getName() {
   System.out.println("in getName()");
    return name;
  }

  public void setName(String name) {
    System.out.println("in setName()");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println("in getServiceCode()");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println("in setServiceCode()");
    this.serviceCode = serviceCode;
  }

public void addAccount(Account account, boolean bool) {
   System.out.println("Doing My DB Work: Add Account...");
 }
public List<Account> findAccounts(){
  List<Account> myAccounts = new ArrayList<>();
  Account acc1 = new Account("TestAcc1", "Silver");
  Account acc2 = new Account("TestAcc2", "Gold");
  Account acc3 = new Account("TestAcc3", "Platinum");
  myAccounts.add(acc3);
  myAccounts.add(acc1);
  myAccounts.add(acc2);
  return myAccounts;
}
}
