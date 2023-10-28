package com.java.bankingApplication0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.bankingApplication0.customerRequest.Branch;
// Repository level of customer entity

public interface BranchRepository extends JpaRepository<Branch, Integer> {
public Branch findByBranchCode(int branchCode);
}
