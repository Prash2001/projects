package com.java.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
  @Autowired
  @Qualifier("newFortuneService")
  private FortuneService fortune;

  @Autowired
  @Qualifier("HAppyFortuneService")
  private HAppyFortuneService fortune1;

  public BaseballCoach() {
    
  }
@PostConstruct
  public void doMyStartupStuff() {
    System.out.println("Welcome to the ALPHA coders");
    System.out.println(fortune.dailyFortune());
  }
@PreDestroy
  public void doMyCleanupStuff() {
    System.out.println("Adios MF");
  }

   public void setFortuneService(FortuneService fortune) {
   this.fortune = fortune;
   fortune = fortune;
   }
  @Override
  public String getDailyWorkout() {
    return "30 min practice of batting";
  }

  @Override
  public String getDailyFortune() {
    return fortune.dailyFortune();
  }

  @Override
  public String getDetails() {
    return fortune1.getName() + fortune1.getNumber();
  }

}
