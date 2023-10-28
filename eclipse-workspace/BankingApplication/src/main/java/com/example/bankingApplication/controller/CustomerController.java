package com.example.bankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankingApplication.customerRequest.*;
import com.example.bankingApplication.dto.CustomerRequest;
import com.example.bankingApplication.service.CustomerService;

@RestController
@RequestMapping("/bootIt")
public class CustomerController {
  @Autowired
  private CustomerService service;

  @PostMapping("/insert")
  public StatusMessageResponse insertCustomer(@RequestBody CustomerRequest request) {
    if (request.customer.getCustomerId() > 99 && request.customer.getCustomerId() < 200)
      throw new ForbiddenException();// Golden Series Customer
    Customer customer = service.insertCustomer(request.customer);;
    try {
      customer = service.insertCustomer(request.customer);
    } catch (Exception e) {
      throw new UnknownException();
    }

    return new StatusMessageResponse(200, "Customer added Successfully", customer);
  }

  @GetMapping("/getCustomerById/{CustomerId}")
  public StatusMessageResponse getCustomerById(@PathVariable int CustomerId) {
    if (CustomerId > 99 && CustomerId < 200)
      throw new ForbiddenException();// Golden Series Customer
    Customer customer;
    try {
      customer = service.getCustomerById(CustomerId);
    } catch (Exception e) {
      throw new UnknownException();
    }
    if (customer == null)
      throw new CustomerNotFoundException();
    return new StatusMessageResponse(200, "Customer fetched Successfully", customer);
  }

  @PutMapping("/updateCustomer")
  public StatusMessageResponse updateCustomer(@RequestBody CustomerRequest request) {
    if (request.customer.getCustomerId() > 99 && request.customer.getCustomerId() < 200)
      throw new ForbiddenException();// Golden Series Customer
    Customer customer0 = service.getCustomerById(request.customer.getCustomerId());
    Customer customer;
    try {
      customer = service.updateCustomer(request.getCustomer());
    } catch (Exception e) {
      throw new UnknownException();
    }

    if (customer0 != null) {
      return new StatusMessageResponse(204, "Customer updated Successfully", customer);
    }
    return new StatusMessageResponse(200, "Customer added Successfully", customer);
  }

  @DeleteMapping("/deleteCustomer/{CustomerId}")
  public StatusMessageResponse deleteCustomer(@PathVariable int CustomerId) {
    Customer customer0 = service.getCustomerById(CustomerId);
    if (customer0 == null) {
      throw new CustomerNotFoundException();
    }
    if (CustomerId > 99 && CustomerId < 200)
      throw new ForbiddenException();// Golden Series Customer

    Customer customer;
    try {
      customer = service.deleteCustomer(CustomerId);
    } catch (Exception e) {
      throw new UnknownException();
    }


    return new StatusMessageResponse(200, "Customer deleted Successfully", customer);
  }

}
