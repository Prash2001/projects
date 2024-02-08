package com.java.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
    Coach theCoach = context.getBean("swimCoach", Coach.class);
    System.out.println(theCoach.getDailyWorkout());
    System.out.println(theCoach.getDailyFortune());
    System.out.println(theCoach.getDetails());
    context.close();
//    Coach theCoach = new BaseballCoach();
//    System.out.println(theCoach.getDailyWorkout());

  }

}
