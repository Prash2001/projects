package com.java.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
  @Autowired
private FortuneService fortuneService;
//@Autowired
  public CricketCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }
  @Override
  public String getDailyWorkout() {
    // TODO Auto-generated method stub
    return "Fast Bowling Practice For 30 Min";
  }

  @Override
  public String getDailyFortune() {
    // TODO Auto-generated method stub
    return fortuneService.dailyFortune();
  }
  @Autowired
private NewFortuneService fortune1;
  @Override
  public String getDetails() {
    return fortune1.getName()+fortune1.getNumber();
  }

}
