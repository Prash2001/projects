package com.java.bankingApplication0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.bankingApplication0.customerRequest.*;
import com.java.bankingApplication0.dto.CustomerRequest;
import com.java.bankingApplication0.service.CustomerService;
// Controller level of banking application.
@RestController
@RequestMapping("/bootIt")
public class CustomerController {
  @Autowired
  private CustomerService service;

  /**
   * Inserts new Customer in database
   * 
   * @return StatusMessageResponse.
   */
  @PostMapping("/insert")
  public StatusMessageResponse insertCustomer(@RequestBody CustomerRequest request) {
    if (request.getCustomer().getCustomerId() > 99 && request.getCustomer().getCustomerId() < 200)
      throw new ForbiddenException();// Golden Series Customer
    Customer customer = service.insertCustomer(request.getCustomer());;
    try {
      customer = service.insertCustomer(request.getCustomer());
    } catch (Exception e) {
      throw new UnknownException();
    }

    return new StatusMessageResponse(200, "Customer added Successfully", customer);
  }

  /**
   * Fetches Customer from database based on the Id
   * 
   * @return StatusMessageResponse.
   */
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

  /**
   * If customer is new then this API will insert new record in DB, and if record with same id is present then updates that record in DB.
   * 
   * @return StatusMessageResponse.
   */
  @PutMapping("/updateCustomer")
  public StatusMessageResponse updateCustomer(@RequestBody CustomerRequest request) {
    if (request.getCustomer().getCustomerId() > 99 && request.getCustomer().getCustomerId() < 200)
      throw new ForbiddenException();// Golden Series Customer
    Customer customer0 = service.getCustomerById(request.getCustomer().getCustomerId());
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

  /**
   * Delete customer from DB
   * 
   * @return StatusMessageResponse.
   */
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
