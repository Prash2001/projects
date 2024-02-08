package com.java.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myBaseballCoach")
@Scope("prototype")
public class BaseballCoach implements Coach {
//private FortuneService fortuneService;
  //@Autowired
  //@Qualifier("myNewFortuneService")
private HappyFortuneService fortuneService;
  @Override
  public String getDailyWorkout() {
    return "30 min practice of baseball";
  }
public BaseballCoach() {}
public BaseballCoach(FortuneService fortuneService) {
  this.fortuneService=(HappyFortuneService)fortuneService;
}

public String getDailyFortune() {
  return fortuneService.getDailyFortune();
}
public String getDetails() {
  return fortuneService.getName()+fortuneService.getNumber();
}
//@Autowired
//public void setFortuneService(HappyFortuneService fortuneService) {
//  this.fortuneService = fortuneService;
//}
@PostConstruct
public void doMyStartupStuff() {
  System.out.println("Wecome to alpha Coders!");
}
@PreDestroy
public void doMyCleanupStuff() {
  System.out.println("Adios MF!");
}
}
