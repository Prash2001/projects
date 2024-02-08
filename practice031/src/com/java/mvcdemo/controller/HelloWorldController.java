package com.java.mvcdemo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
@RequestMapping("/showForm")
public String showForm() {
  return "helloworld-form";
}
@RequestMapping("/processForm")
public String processForm(HttpServletRequest request, Model theModel) {
  String name = request.getParameter("firstName");
  name = name.toUpperCase();
  String message = "Hey "+name;
  theModel.addAttribute("message", message);
  return "helloworld";
}
}
