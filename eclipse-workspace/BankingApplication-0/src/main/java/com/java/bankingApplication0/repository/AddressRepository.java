package com.java.bankingApplication0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.bankingApplication0.customerRequest.Address;
// Repository level of address entity

public interface AddressRepository extends JpaRepository<Address, String> {
  public Address findByPincode(String pincode);
}
