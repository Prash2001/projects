package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.customerRequest.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
  public Branch findByBranchCode(int branchCode);
}
