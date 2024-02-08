package com.java.aopdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.service.FortuneService;

public class AroundHandleExceptionDemoApp {
private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    FortuneService theFortune = context.getBean("fortuneService", FortuneService.class);
    myLogger.info("Main App");
    myLogger.info("--------");
    myLogger.info("Calling getFortune()");
    boolean tripWire = true;
    String data = theFortune.getDailyFortune(tripWire);
    myLogger.info("My Fortune : "+data);
    myLogger.info("Finish");
    context.close();

  }

}
