package com.java.aopdemo;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
    AccountDAO theDAO = context.getBean("accountDAO", AccountDAO.class);
    List<Account> listAccounts = theDAO.findAccounts();
    System.out.println("AfterReturningDemoApp");
    System.out.println(listAccounts);
    System.out.println("------------------");
    context.close();

  }

}
