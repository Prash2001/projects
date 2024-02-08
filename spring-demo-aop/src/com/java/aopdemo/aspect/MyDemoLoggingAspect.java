package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
 @Before("execution(* add*(com.java.aopdemo.Account,boolean))")
 public void beforeAccountAdvice() {
   System.out.println("Executing @Before Advice on addAccount()");
 }
}
