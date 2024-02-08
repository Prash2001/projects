package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
public class EmployeeController {
  private List<Employee> employees;
@PostConstruct
public void loadData() {
  Employee emp1 = new Employee(1,"luffy","monkey","luffy@sea.com");
  Employee emp2 = new Employee(1,"zoro","Roronoa","zoro@sea.com");
  Employee emp3 = new Employee(1,"Brook","SoulKing","brook@sea.com");
  employees = new ArrayList<>();
  employees.add(emp1);
  employees.add(emp2);
  employees.add(emp3);
}
@GetMapping("/list")
public String listEmployees(Model theModel) {
  theModel.addAttribute("employees", employees);
  return "list-employees";
}
}
