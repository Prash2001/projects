package com.java.fileDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.fileDemo.model.Doc;

public interface DocRepository extends JpaRepository<Doc, Integer> {

}
