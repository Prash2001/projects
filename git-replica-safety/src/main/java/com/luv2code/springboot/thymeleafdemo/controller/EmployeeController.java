package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
private EmployeeService employeeService;
@Autowired
public EmployeeController(EmployeeService theEmployeeService) {
  employeeService = theEmployeeService;
}
@GetMapping("/list")
public String listEmployees(Model theModel) {
  theModel.addAttribute("employees", employeeService.findAll());
  return "/employees/list-employees";
}
@GetMapping("/showFormForAdd")
public String showFormForAdd(Model model) {
  Employee theEmployee = new Employee();
  model.addAttribute("employee", theEmployee);
  return "employees/employee-form";
}
@PostMapping("/save")
public String save(@ModelAttribute("employee") Employee employee) {
  employeeService.save(employee);
  return "redirect:/employees/list";
}
@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
  Employee emp = employeeService.findById(theId);
  theModel.addAttribute("employee",emp);
  return "employees/employee-form";
}
@GetMapping("/deleteEmployee")
public String deleteEmployee(@RequestParam("employeeId") int theId, Model theModel) {
  employeeService.deleteById(theId);
  return "redirect:/employees/list";
}
}
