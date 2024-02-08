package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  
  //private EmployeeDAO employeeDAO;

//  @Autowired
//  public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO theEmployeeDAO) {
//    employeeDAO = theEmployeeDAO;
//  }
  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
    employeeRepository = theEmployeeRepository;
  }
  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeRepository.findAllByOrderByLastNameAsc();
  }

  @Override
  @Transactional
  public Employee findById(int id) {
    Optional<Employee> emp = employeeRepository.findById(id);
    Employee employee = null;
    if(emp.isPresent()) {
      employee = emp.get();
    }else {
      throw new RuntimeException("Employee Id Not Found - "+id);
    }
    return employee;
  }

  @Override
  @Transactional
  public void save(Employee theEmployee) {
    employeeRepository.save(theEmployee);

  }

  @Override
  @Transactional
  public void deleteById(int id) {
    employeeRepository.deleteById(id);

  }

}
