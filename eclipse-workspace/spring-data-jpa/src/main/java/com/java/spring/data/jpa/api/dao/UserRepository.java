package com.java.spring.data.jpa.api.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.java.spring.data.jpa.api.model.Customer;
@Repository
public interface UserRepository extends JpaRepository<Customer, Integer> {

  public Customer findByName(String name);
  
  public Customer findById(int id);
  
  public void deleteById(int id);
  
  public Customer findByNameAndProfessionAndAge(String name, String profession, int age);
  
 /* @Query("select u from User u")
  public List<Customer> getCustomerCustomQuery();*/
}
