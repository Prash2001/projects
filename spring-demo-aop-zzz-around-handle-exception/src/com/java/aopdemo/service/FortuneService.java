package com.java.aopdemo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class FortuneService {
public String getDailyFortune() {
  try {
    TimeUnit.SECONDS.sleep(5);
  } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  return "Expect heavy traffic";
}

public String getDailyFortune(boolean tripWire) {
  if(tripWire) {
    throw new RuntimeException("Major Accident, Highway is closed!");
  }
  return getDailyFortune();
}
}
