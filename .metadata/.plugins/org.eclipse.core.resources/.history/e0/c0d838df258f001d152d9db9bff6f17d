package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

  @Pointcut("execution(* com.java.aopdemo.dao.*.*(..))")
  public void forDAOPackage() {
    //System.out.println("Executing @Before Advice on addAccount()");
  }
  
  @Pointcut("execution(* com.java.aopdemo.dao.*.get*(..))")
  public void getter() {
    //System.out.println("Executing @Before Advice on addAccount()");
  }
  @Pointcut("execution(* com.java.aopdemo.dao.*.set*(..))")
  public void setter() {
    //System.out.println("Executing @Before Advice on addAccount()");
  }

  @Pointcut("forDAOPackage() && !(getter() || setter())")
  public void foerDAOPackeageExceptGetAndSet() {
    //System.out.println("Executing @Before Advice on addAccount()");
  }
  @Before("foerDAOPackeageExceptGetAndSet()")
  public void beforeAddAccountAdvice() {
    System.out.println("Executing @Before Advice on addAccount()");
  }

  @Before("forDAOPackage()")
  public void performApiAnalytics() {
    System.out.println("Performing API analytics @Before Advice on addAccount()");
  }
}
