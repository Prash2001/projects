package com.java.springdemo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class HAppyFortuneService implements FortuneService {
 // @Value("${foo.name}")
private String name = "Test";
  //@Value("${foo.number}")
private int number = 1;
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
  @Override
  public String dailyFortune() {
    return "Today is your lucky day!";
  }

}
