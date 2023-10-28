package com.java.bankingApplication0.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.bankingApplication0.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long>{

  Optional<ImageData> findByName(String fileName);
  
}
