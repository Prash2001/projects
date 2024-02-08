package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect { 
  @Before("com.java.aopdemo.aspect.JavaAopExpressions.forDAOPackeageExceptGetAndSet()")
  private void beforeAddAccountAdvice() {
    System.out.println("1 ------------> Executing @Before Advice on addAccount()");
  }

}
