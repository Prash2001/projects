package com.java.springdemo;

import org.springframework.stereotype.Component;

@Component("myNewFortuneService")
public class NewFortuneService implements FortuneService{

  @Override
  public String getDailyFortune() {
    // TODO Auto-generated method stub
    return "Day is Yours!";
  }

}
