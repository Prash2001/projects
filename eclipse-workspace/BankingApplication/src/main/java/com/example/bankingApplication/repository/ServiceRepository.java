package com.example.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.bankingApplication.serviceRequest.Locker;
import com.example.bankingApplication.serviceRequest.Service;
import com.example.bankingApplication.serviceRequest.ServicePk;

public interface ServiceRepository extends CrudRepository<Service, ServicePk> {
  public Service findByLocker(Locker locker);
  

}
