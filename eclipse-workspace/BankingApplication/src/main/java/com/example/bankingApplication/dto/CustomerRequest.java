package com.example.bankingApplication.dto;

import com.example.bankingApplication.customerRequest.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequest {

  public Customer customer;

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
 
}
