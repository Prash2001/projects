package com.java.bankingApplication0.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.bankingApplication0.customerRequest.Address;
import com.java.bankingApplication0.customerRequest.Branch;
import com.java.bankingApplication0.customerRequest.CreditCard;
import com.java.bankingApplication0.customerRequest.Customer;
import com.java.bankingApplication0.customerRequest.Customer.CustomerAccType;
import com.java.bankingApplication0.repository.AddressRepository;
import com.java.bankingApplication0.repository.BranchRepository;
import com.java.bankingApplication0.repository.CreditCardRepository;
import com.java.bankingApplication0.repository.CustomerRepository;

// Service layer of banking application.
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


  // Dummy data in H2 database.
  @PostConstruct
  public void initDB() {
    Branch b1 = new Branch();
    b1.setBranchCode(8213);
    b1.setBranchIFSCCode("IFSC3973243");
    b1.setBranchName("Nigdi");
    bRepository.save(b1);

    Address a1 = new Address();
    a1.setCity("Pune");
    a1.setPincode("414013");
    a1.setState("MH");
    a1.setStreet("Aundh-Baner");
    aRepository.save(a1);

    CreditCard c1 = new CreditCard();
    c1.setCardNumber("7323 4323 2344 5544");
    c1.setCardLimit(23000);
    c1.setExpiryDate(Date.from(Instant.now()));
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
    customers.add(new Customer(100, "TestUser5", 2132132, "Projet Manager", 25,
        CustomerAccType.Saving, b1, c1, a1));
    repository.saveAll(customers);
  }

  /**
   * Inserts new Customer in database
   * 
   * @param Customer
   * @return Customer
   */
  public Customer insertCustomer(Customer customer) {
    bRepository.save(customer.getCustomerBranchDetails());
    cRepository.save(customer.getCustomerCreditCard());
    aRepository.save(customer.getCustomerAddress());
    return repository.save(customer);
  }

  /**
   * Fetch Customer from database
   * 
   * @param int id
   * @return Customer
   */
  public Customer getCustomerById(int id) {
    return repository.findByCustomerId(id);
  }

  /**
   * Updates branch while updating Customer
   * 
   * @param Branch
   * @return Branch.
   */
  public Branch updateBranch(Branch b1) {
    Branch b2;
    if (bRepository.existsById(b1.getBranchCode())) {
      b2 = bRepository.findByBranchCode(b1.getBranchCode());
      b2.setBranchName(b1.getBranchName());
      b2.setBranchIFSCCode(b1.getBranchIFSCCode());
    } else {
      b2 = new Branch();
      b2.setBranchCode(b1.getBranchCode());
      b2.setBranchName(b1.getBranchName());
      b2.setBranchIFSCCode(b1.getBranchIFSCCode());
    }
    return bRepository.save(b2);
  }

  /**
   * Updates Credit card while updating Customer
   * 
   * @param Credit Card
   * @return Credit Card.
   */
  public CreditCard updateCreditCard(CreditCard c1) {
    CreditCard c2;
    if (cRepository.existsById(c1.getCardNumber())) {
      c2 = cRepository.findByCardNumber(c1.getCardNumber());
      c2.setCardLimit(c1.getCardLimit());
      c2.setExpiryDate(c1.getExpiryDate());
    } else {
      c2 = new CreditCard();
      c2.setCardNumber(c1.getCardNumber());
      c2.setCardLimit(c1.getCardLimit());
      c2.setExpiryDate(c1.getExpiryDate());
    }
    return cRepository.save(c2);
  }

  /**
   * Updates Address while updating Customer
   * 
   * @param Address
   * @return Address.
   */
  public Address updateAddress(Address a1) {
    Address a2;
    if (aRepository.existsById(a1.getPincode())) {
      a2 = aRepository.findByPincode(a1.getPincode());
      a2.setState(a1.getState());
      a2.setCity(a1.getCity());
      a2.setStreet(a1.getStreet());
    } else {
      a2 = new Address();
      a2.setPincode(a1.getPincode());
      a2.setState(a1.getState());
      a2.setCity(a1.getCity());
      a2.setStreet(a1.getStreet());
    }
    return aRepository.save(a2);
  }

  /**
   * Updates Customer
   * 
   * @param Customer
   * @return Customer.
   */
  public Customer updateCustomer(Customer cust) {
    Customer customer;
    if (repository.existsById(cust.getCustomerId())) {
      customer = repository.findByCustomerId(cust.getCustomerId());
      customer.setCustomerName(cust.getCustomerName());
      customer.setCustomerAccNum(cust.getCustomerAccNum());
      customer.setCustomerBranchDetails(updateBranch(cust.getCustomerBranchDetails()));
      customer.setAccType(cust.getAccType());
      customer.setCustomerContactNum(cust.getCustomerContactNum());
      customer.setCustomerCreditCard(updateCreditCard(cust.getCustomerCreditCard()));
      customer.setCustomerPancardNum(cust.getCustomerPancardNum());
      customer.setCustomerAddress(updateAddress(cust.getCustomerAddress()));
    } else {
      bRepository.save(cust.getCustomerBranchDetails());
      cRepository.save(cust.getCustomerCreditCard());
      aRepository.save(cust.getCustomerAddress());
      customer = cust;
    }
    return repository.save(customer);
  }

  /**
   * Delete Customer from database
   * 
   * @param int CustomerId
   * @return Customer.
   */
  public Customer deleteCustomer(int CustomerId) {
    Customer customer = repository.findByCustomerId(CustomerId);
    repository.delete(customer);
    return customer;
  }
}
