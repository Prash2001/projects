package com.java.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
  public boolean addAccount() {
    System.out.println("Doing My DB Work: Add Account... in membership");
    return true;
  }
}
