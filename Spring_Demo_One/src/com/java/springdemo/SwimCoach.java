package com.java.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
  @Autowired
private FortuneService fortuneService;
//@Autowired
  public SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }
  @Override
  public String getDailyWorkout() {
    // TODO Auto-generated method stub
    return "BackStroke Practice For 30 Min";
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
