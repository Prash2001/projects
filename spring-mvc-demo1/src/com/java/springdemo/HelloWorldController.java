package com.java.springdemo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
  @RequestMapping("/showForm")
public String showForm() {
  return "helloworld-form";
}
  @RequestMapping("/processForm")
  public String processForm() {
    return "helloworld";
  }
  @RequestMapping("processFormVersionTwo")
  public String  letShoutDude(HttpServletRequest request, Model model) {
    String name = request.getParameter("studentName1");
    name = name.toUpperCase();
    String result = "Yo! " + name;
    model.addAttribute("message", result);
    return "helloworld1";
  }
  
 @RequestMapping("processFormVersionThree")
public String  processFormVersionThree(@RequestParam("studentName1")String name, Model model) {
    name = name.toUpperCase();
    String result = "Yo! Man " + name;
    model.addAttribute("message", result);
    return "helloworld1";
  }
}
