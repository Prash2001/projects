package com.java.aopdemo.dao;

import org.springframework.stereotype.Component;
import com.java.aopdemo.Account;

@Component
public class AccountDAO {
 public void addAccount(Account account, boolean bool) {
   System.out.println("Doing My DB Work: Add Account...");
 }
}
