package com.java.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
  private Logger myLogger = Logger.getLogger(getClass().getName());

  @Around("execution(* com.java.aopdemo.service.FortuneService.getDailyFortune(..))")
  public Object aroundHandleException(ProceedingJoinPoint theJoinPoint) throws Throwable {
    String method = theJoinPoint.getSignature().toShortString();
    myLogger.info("Executing @Around Advice on method : " + method);
    long begin = System.currentTimeMillis();
    Object result = null;
    try {
       result = theJoinPoint.proceed();
    }
    catch (Exception e) {
      myLogger.warning(e.getMessage());
      throw e;
      // In case of handling exception
      //return "Nothing exciting here, Continue with other services";
    }
    long duration = System.currentTimeMillis() - begin;
    myLogger.info("Duration = " + duration / 1000.0 + " Seconds");
    return result;
  }

  @Around("execution(* com.java.aopdemo.service.FortuneService.getDailyFortune())")
  public Object aroundGetDailyFortune(ProceedingJoinPoint theJoinPoint) throws Throwable {
    String method = theJoinPoint.getSignature().toShortString();
    myLogger.info("Executing @Around Advice on method : " + method);
    long begin = System.currentTimeMillis();
    Object result = theJoinPoint.proceed();
    long duration = System.currentTimeMillis() - begin;
    myLogger.info("Duration = " + duration / 1000.0 + " Seconds");
    return result;
  }

  @After("execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
    String method = theJoinPoint.getSignature().toShortString();
    myLogger.info("Running @After Advice on method : " + method);
    myLogger.info("Runing any way");
  }

  @AfterThrowing(pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing = "Exc")
  public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable Exc) {
    String method = theJoinPoint.getSignature().toShortString();
    myLogger.info("Executing @AfterThrowing on method :" + method);
    myLogger.info("The Exception is ========> " + Exc);
  }

  @AfterReturning(pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccounts(JoinPoint theJoinPoint, List<Account> result) {
    String method = theJoinPoint.getSignature().toShortString();
    myLogger.info("Executing @AfterReturning on method : " + method);
    myLogger.info("Result : " + result);
    // Modifying data for visualization
    convertAccountNamesToUppercase(result);
  }

  private void convertAccountNamesToUppercase(List<Account> result) {
    for (Account acc : result) {
      acc.setName(acc.getName().toUpperCase());
      acc.setLevel(acc.getLevel().toUpperCase());
    }
  }

  @Before("com.java.aopdemo.aspect.JavaAopExpressions.forDAOPackeageExceptGetAndSet()")
  private void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    myLogger.info("1 ------------> Executing @Before Advice on addAccount()");
    MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
    myLogger.info(methodSig.toString());
    Object[] args = theJoinPoint.getArgs();
    for (Object arg : args) {
      myLogger.info(arg.toString());
      if (arg instanceof Account) {
        // Downcast and print account related stuff
        Account theAccount = (Account) arg;
        myLogger.info(theAccount.getName() + "  " + theAccount.getLevel());
      }
    }
  }

}
