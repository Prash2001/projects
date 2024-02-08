package com.java.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

  public static void main(String[] args) {
    //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
    Coach theCoach = context.getBean("myBaseballCoach", Coach.class);
    System.out.println(theCoach.getDailyWorkout());
    System.out.println(theCoach.getDailyFortune());
    
    System.out.println(theCoach.getDetails());
    context.close();
  }

}
