package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.customerRequest.Address;

// Repository level of address entity
public interface AddressRepository extends JpaRepository<Address, String> {
  public Address findByPincode(String pincode);
}
