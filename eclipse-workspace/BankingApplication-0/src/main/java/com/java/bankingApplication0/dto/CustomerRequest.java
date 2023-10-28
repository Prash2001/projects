package com.java.bankingApplication0.dto;

import com.java.bankingApplication0.customerRequest.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
// DTO class for customer entity
public class CustomerRequest {

  private Customer customer;

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
 
}
