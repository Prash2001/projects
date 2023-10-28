package com.java.spring.data.jpa.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankingApplication.customerRequest.StatusMessageResponse;
import com.java.spring.data.jpa.api.model.CustomException;
import com.java.spring.data.jpa.api.model.Customer;
import com.java.spring.data.jpa.api.model.CustomerNotFoundException;
import com.java.spring.data.jpa.api.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {

  @Autowired
  private UserService service;
  
  /*@GetMapping("/getCustomers")
  public List<Customer> getCustomers(){
    return service.getCustomers();
  }*/
  
  @GetMapping("/getCustomerByName/{name}")
  public StatusMessageResponse getCustomerByName(@PathVariable String name) {
    try {
      return new StatusMessageResponse(200, "Succesfully fetched customer", service.getCustomerByName(name));
    }catch(Exception e) {
      return new StatusMessageResponse(e.hashCode(),e.getMessage(), null);
    }
  }
  
  @GetMapping("/getCustomerById/{id}")
  public StatusMessageResponse getCustomerById(@PathVariable int id) throws Exception {
//    try {
//      return new StatusMessageResponse(200, "Succesfully fetched customer using id", service.getCustomerById(id));
//    }catch(CustomException e) {
//      System.out.println("In Exception");
//      return new StatusMessageResponse(e.hashCode(),e.getMessage(), null);
//    }
    Customer customer = service.getCustomerById(id);
    if(customer == null)throw new CustomerNotFoundException();
    
      return new StatusMessageResponse(200, "" , customer);
  }
  
  /*@GetMapping("/getCustomerByNameAndProfessionAndAge/{name}/{profession}/{age}")
  public Customer getCustomerByINameProfessionAndAge(@PathVariable String name, @PathVariable String profession, @PathVariable int age) {
    return service.getCustomerByINameProfessionAndAge(name, profession, age);
  }
  
  @DeleteMapping("/deleteCustomerById/{id}")
  public String deleteCustomerById(@PathVariable int id) {
    service.deleteCustomerById(id);
    return "Customer deleted susuccessfully";
  }
  
  @GetMapping("/getPaginatedCustomers")
  public Page<Customer> getPaginatedCustomers(){
    return service.getPaginatedCustomers();
  }
  
  @GetMapping("/getUsersIgnoreCase")
  public Page<Customer> getUsersByProfession(){
    return service.getPaginatedCustomers();
  }*/
}
