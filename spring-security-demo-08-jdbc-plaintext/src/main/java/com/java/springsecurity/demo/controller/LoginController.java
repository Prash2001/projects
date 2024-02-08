package com.java.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  @GetMapping("/showMyLoginPage")
  public String shoeMyLoginPage() {
    return "fancy-login";
  }
}
