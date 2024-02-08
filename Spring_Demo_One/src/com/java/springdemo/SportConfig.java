package com.java.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:info.properties")
//@ComponentScan("com.java.springdemo")
public class SportConfig {
  @Bean
  public FortuneService newFortuneService() {
    NewFortuneService myFortuneService = new NewFortuneService();
    return myFortuneService;
  }
  @Bean
  public Coach swimCoach() {
    SwimCoach myCoach = new SwimCoach(newFortuneService());
    return myCoach;
  }
}
