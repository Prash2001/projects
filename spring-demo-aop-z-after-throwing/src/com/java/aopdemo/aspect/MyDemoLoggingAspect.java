package com.java.aopdemo.aspect;

import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.java.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect { 
  
  @AfterThrowing(
      pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing = "Exc")
  public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable Exc) {
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("Executing @AfterThrowing on method :"+ method);
    System.out.println("The Exception is ========> "+Exc);
  }
  @AfterReturning(pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccounts(JoinPoint theJoinPoint, List<Account> result) {
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("Executing @AfterReturning on method : "+method);
    System.out.println("Result : "+result);
    // Modifying data for visualization
    convertAccountNamesToUppercase(result);
  }
  private void convertAccountNamesToUppercase(List<Account> result) {
    for(Account acc : result) {
      acc.setName(acc.getName().toUpperCase());
      acc.setLevel(acc.getLevel().toUpperCase());
    }  
  }
  @Before("com.java.aopdemo.aspect.JavaAopExpressions.forDAOPackeageExceptGetAndSet()")
  private void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    System.out.println("1 ------------> Executing @Before Advice on addAccount()");
    MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
    System.out.println(methodSig);
    Object[] args = theJoinPoint.getArgs();
    for(Object arg : args) {
      System.out.println(arg);
      if(arg instanceof Account) {
        //Downcast and print account related stuff
        Account theAccount = (Account) arg;
        System.out.println(theAccount.getName()+"  "+theAccount.getLevel());
      }
    }
  }

}
