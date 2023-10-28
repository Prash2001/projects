package com.example.bankingApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.bankingApplication.customerRequest.*;

// Repository level of Customer Entity
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  // Finding record using id
  public Customer findByCustomerId(int CustomerId);

}
