package com.java.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.java.springdemo")
@PropertySource("classpath:info.properties")
public class SportConfig {
  @Bean
  public FortuneService happyFortuneService() {
    return new HappyFortuneService();
  }
  @Bean
  public FortuneService newFortuneService() {
    return new NewFortuneService();
  }
@Bean
public Coach myBaseballCoach() {
  Coach myCoach = new BaseballCoach(happyFortuneService());
  return myCoach;
}
}
