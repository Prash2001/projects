package com.example.bankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankingApplication.customerRequest.Customer;
import com.example.bankingApplication.customerRequest.CustomerNotFoundException;
import com.example.bankingApplication.customerRequest.ForbiddenException;
import com.example.bankingApplication.customerRequest.StatusMessageResponse;
import com.example.bankingApplication.customerRequest.UnknownException;
import com.example.bankingApplication.dto.CustomerRequest;
import com.example.bankingApplication.dto.ServiceRequest;
import com.example.bankingApplication.service.ServiceService;
import com.example.bankingApplication.serviceRequest.Loan;
import com.example.bankingApplication.serviceRequest.Service;

@RestController
@RequestMapping("/bootIt")
public class ServiceController {

  @Autowired
  public ServiceService service;

  @PostMapping("/service")
  public StatusMessageResponse insertService(@RequestBody ServiceRequest request) {
//    if (request.customer.customerId > 99 && request.customer.customerId < 200)
//      throw new ForbiddenException();// Golden Series Customer
    Service myService = service.insertService(request.service);;
//    try {
//      customer = service.insertCustomer(request.customer);
//    } catch (Exception e) {
//      throw new UnknownException();
//    }

    return new StatusMessageResponse(200, "Service added Successfully", myService);
  }
//  @GetMapping("/service/Loan/{LoanNumber}")
//  public StatusMessageResponse getServiceByLoanNumber(@PathVariable int LoanNumber) {
//    Loan myRequest;;
//    try {
//      myRequest = service.getServiceByLoanNumber(LoanNumber);
//    } catch (Exception e) {
//      throw new UnknownException();
//    }
//    if (myRequest == null)
//      throw new CustomerNotFoundException();
//    return new StatusMessageResponse(200, "Loan Service fetched Successfully", myRequest);
//  }
  
  
}
