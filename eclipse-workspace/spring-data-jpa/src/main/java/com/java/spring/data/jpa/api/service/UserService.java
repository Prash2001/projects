package com.java.spring.data.jpa.api.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import com.java.spring.data.jpa.api.dao.UserRepository;
import com.java.spring.data.jpa.api.model.Customer;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  @PostConstruct
  public void initDB() {
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1, "TestUser1", "IT Professional", 21));
    customers.add(new Customer(2, "TestUser2", "BE developer", 22));
    customers.add(new Customer(3, "TestUser3", "FE developer", 23));
    customers.add(new Customer(4, "TestUser4", "FS developer", 24));
    customers.add(new Customer(5, "TestUser5", "Projet Manager", 25));
    repository.saveAll(customers);
  }

  public List<Customer> getCustomers() {
    return repository.findAll();
  }

  public Customer getCustomerByName(String name) {
    return repository.findByName(name);
  }

  public Customer getCustomerById(int id) {
    return repository.findById(id);
  }
  
  public Customer addCustomerById(Customer customer) {
    return repository.save(customer);
  }

  public void deleteCustomerById(int id) {
    repository.deleteById(id);
  }

  public Customer getCustomerByINameProfessionAndAge(String name, String profession, int age) {
    return repository.findByNameAndProfessionAndAge(name, profession, age);
  }

  public Page<Customer> getPaginatedCustomers() {
    return repository.findAll(PageRequest.of(0, 2, Sort.by("name").descending()));
  }

}
