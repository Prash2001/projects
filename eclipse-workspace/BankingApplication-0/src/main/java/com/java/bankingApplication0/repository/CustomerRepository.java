package com.java.bankingApplication0.repository;

import org.springframework.data.repository.CrudRepository;
// Repository level of customer entitu
import org.springframework.stereotype.Repository;
import com.java.bankingApplication0.customerRequest.*;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  public Customer findByCustomerId(int CustomerId);
  
  public  <S extends Customer> S save(Customer cus);

}
