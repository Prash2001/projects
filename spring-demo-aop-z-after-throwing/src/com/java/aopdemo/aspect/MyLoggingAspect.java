package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyLoggingAspect {
  @Before("com.java.aopdemo.aspect.JavaAopExpressions.forDAOPackeageExceptGetAndSet()")
  private void loggingAspect() {
    System.out.println("3 ---------> Performing Logging @Before Advice on addAccount()");
  }
}
