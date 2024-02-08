package com.java.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myFortuneService")
public class HappyFortuneService implements FortuneService {
  @Value("${foo.name}")
private String name;
  @Value("${foo.number}")
private int number;
  @Override
  public String getDailyFortune() {
    return "Today is your lucky day!";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getNumber() {
    return number;
  }
  public void setNumber(int number) {
    this.number = number;
  }

}
