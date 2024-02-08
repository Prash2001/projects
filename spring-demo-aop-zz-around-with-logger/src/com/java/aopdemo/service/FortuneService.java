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
}
