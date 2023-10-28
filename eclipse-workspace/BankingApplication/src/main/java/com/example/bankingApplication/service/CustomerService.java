package com.example.bankingApplication.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bankingApplication.customerRequest.Address;
import com.example.bankingApplication.customerRequest.Branch;
import com.example.bankingApplication.customerRequest.CreditCard;
import com.example.bankingApplication.customerRequest.Customer;
import com.example.bankingApplication.customerRequest.Customer.CustomerAccType;
import com.example.bankingApplication.repository.AddressRepository;
import com.example.bankingApplication.repository.BranchRepository;
import com.example.bankingApplication.repository.CreditCardRepository;
import com.example.bankingApplication.repository.CustomerRepository;

@Service
public class CustomerService {



  @Autowired
  private CustomerRepository repository;

  @Autowired
  private BranchRepository bRepository;

  @Autowired
  private CreditCardRepository cRepository;

  @Autowired
  private AddressRepository aRepository;

  @PostConstruct
  public void initDB() {
    Branch b1 = new Branch();
    b1.setBranchCode(8213);
    b1.setBranchIFSCCode("IFSC3973243");
    b1.setBranchName("Nigdi");
    bRepository.save(b1);

    Address a1 = new Address();
    a1.setCity("Pune");
    a1.pincode = "414013";
    a1.state = "MH";
    a1.street = "Aundh-Baner";
    aRepository.save(a1);

    CreditCard c1 = new CreditCard();
    c1.cardNumber = "7323 4323 2344 5544";
    c1.cardLimit = 23000;
    c1.expiryDate = Date.from(Instant.now());
    cRepository.save(c1);


    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1, "TestUser1", 213223, "IT Professional", 21,
        CustomerAccType.Saving, b1, c1, a1));
    customers.add(new Customer(2, "TestUser2", 123323, "BE developer", 22, CustomerAccType.Saving,
        b1, c1, a1));
    customers.add(new Customer(3, "TestUser3", 1233123, "FE developer", 23, CustomerAccType.Saving,
        b1, c1, a1));
    customers.add(new Customer(4, "TestUser4", 2132323, "FS developer", 24, CustomerAccType.Saving,
        b1, c1, a1));
    customers.add(new Customer(5, "TestUser5", 2132132, "Projet Manager", 25,
        CustomerAccType.Saving, b1, c1, a1));
    repository.saveAll(customers);
  }

  public Customer insertCustomer(Customer customer) {
    bRepository.save(customer.customerBranchDetails);
    cRepository.save(customer.customerCreditCard);
    aRepository.save(customer.customerAddress);
    return repository.save(customer);
  }

  public Customer getCustomerById(int id) {
    return repository.findByCustomerId(id);
  }

  public Customer updateCustomer(Customer cust) {
    Customer customer;
    if (repository.existsById(cust.getCustomerId())) {
      customer = repository.findByCustomerId(cust.getCustomerId());
      customer.customerName = cust.customerName;
      customer.customerAccNum = cust.customerAccNum;
      customer.customerBranchDetails = cust.customerBranchDetails;
      customer.setAccType(cust.getAccType());
      customer.customerContactNum = cust.customerContactNum;
      customer.customerCreditCard = cust.customerCreditCard;
      customer.customerPancardNum = cust.customerPancardNum;
      customer.customerAddress = cust.customerAddress;
    } else {
      customer = cust;
    }
    return repository.save(customer);
  }

  public Customer deleteCustomer(int CustomerId) {
    Customer customer = repository.findByCustomerId(CustomerId);
    repository.delete(customer);
    return customer;
  }
}
