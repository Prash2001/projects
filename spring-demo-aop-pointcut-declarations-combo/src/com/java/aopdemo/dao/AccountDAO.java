package com.java.aopdemo.dao;

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
}
