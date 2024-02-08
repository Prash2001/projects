package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAnalyticsAspect {
  @Before("com.java.aopdemo.aspect.JavaAopExpressions.forDAOPackeageExceptGetAndSet()")
  private void performApiAnalytics() {
    System.out.println("2 ------------>Performing API analytics @Before Advice on addAccount()");
  }
}
