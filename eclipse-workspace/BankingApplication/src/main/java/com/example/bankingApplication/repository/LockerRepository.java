package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankingApplication.serviceRequest.Locker;

public interface LockerRepository extends JpaRepository<Locker, Integer> {

  public Locker findByLockerNum(int lockerNum);
}
