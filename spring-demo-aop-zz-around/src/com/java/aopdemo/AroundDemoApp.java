package com.java.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.service.FortuneService;

public class AroundDemoApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    FortuneService theFortune = context.getBean("fortuneService", FortuneService.class);
    System.out.println("Main App");
    System.out.println("--------");
    System.out.println("Calling getFortune()");
    String data = theFortune.getDailyFortune();
    System.out.println("My Fortune : "+data);
    System.out.println("Finish");
    context.close();

  }

}
