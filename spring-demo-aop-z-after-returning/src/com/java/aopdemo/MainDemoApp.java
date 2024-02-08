package com.java.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.dao.AccountDAO;
import com.java.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
    AccountDAO theDAO = context.getBean("accountDAO", AccountDAO.class);
    Account acc = new Account();
    acc.setLevel("Debug");
    acc.setName("TestName");
    theDAO.addAccount(acc, true);
    theDAO.setName("TestDAO");
    theDAO.setServiceCode("TestServiceCode");
    System.out.println(theDAO.getName()+" "+theDAO.getServiceCode());
    MembershipDAO theMemberDAO = context.getBean("membershipDAO", MembershipDAO.class);
    theMemberDAO.addAccount();
    context.close();

  }

}
