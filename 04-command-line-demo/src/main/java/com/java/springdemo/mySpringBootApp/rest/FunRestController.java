
package com.java.springdemo.mySpringBootApp.rest;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
  @GetMapping("/")
  public String sayHello() {
    return "Hello World! current time on server is " + LocalDateTime.now();
  }
  @GetMapping("/workout")
  public String getDailyWorkout() {
    return "Run hard 5k!";
  }
}
