package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.serviceRequest.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
  public Insurance findByInsuranceId(int insuranceId);
}
