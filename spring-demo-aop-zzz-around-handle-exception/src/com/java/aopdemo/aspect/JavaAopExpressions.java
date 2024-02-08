package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class JavaAopExpressions {
  @Pointcut("execution(* com.java.aopdemo.dao.*.*(..))")
  public void forDAOPackage() {
    // System.out.println("Executing @Before Advice on addAccount()");
  }

  @Pointcut("execution(* com.java.aopdemo.dao.*.get*(..))")
  public void getter() {
    // System.out.println("Executing @Before Advice on addAccount()");
  }

  @Pointcut("execution(* com.java.aopdemo.dao.*.set*(..))")
  public void setter() {
    // System.out.println("Executing @Before Advice on addAccount()");
  }
  
  @Pointcut("forDAOPackage() && !(getter() || setter())")
  public void forDAOPackeageExceptGetAndSet() {
    // System.out.println("Executing @Before Advice on addAccount()");
  }

}
