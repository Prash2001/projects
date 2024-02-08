package com.java.aopdemo;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    AccountDAO theDAO = context.getBean("accountDAO", AccountDAO.class);
    List<Account> listAccounts = null;
    try {
      boolean tripWire = true;
     listAccounts = theDAO.findAccounts(tripWire);
    }
    catch(Exception e) {
      System.out.println("Exception in Main Program");
    }
    System.out.println("AfterReturningDemoApp");
    System.out.println(listAccounts);
    System.out.println("------------------");
    context.close();

  }

}
