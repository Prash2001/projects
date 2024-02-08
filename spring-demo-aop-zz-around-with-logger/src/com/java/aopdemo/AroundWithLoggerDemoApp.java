package com.java.aopdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.service.FortuneService;

public class AroundWithLoggerDemoApp {
private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    FortuneService theFortune = context.getBean("fortuneService", FortuneService.class);
    myLogger.info("Main App");
    myLogger.info("--------");
    myLogger.info("Calling getFortune()");
    String data = theFortune.getDailyFortune();
    myLogger.info("My Fortune : "+data);
    myLogger.info("Finish");
    context.close();

  }

}
