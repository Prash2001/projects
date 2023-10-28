package com.java.employeemanagementsystem.service;

import com.java.employeemanagementsystem.entity.Employee;
import com.java.employeemanagementsystem.model.EmployeeRequest;
import com.java.employeemanagementsystem.model.EmployeeResponse;
import com.java.employeemanagementsystem.repository.EmployeeRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    final private EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee emp = new Employee();
        emp.setFirstName(employeeRequest.getFirstName());
        emp.setLastName(employeeRequest.getLastName());
        emp.setEmail(employeeRequest.getEmail());
        return mapToDTO(employeeRepository.save(emp));
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private EmployeeResponse mapToDTO(Employee emp) {
        EmployeeResponse res = new EmployeeResponse();
        res.setId(emp.getId());
        res.setFirstName(emp.getFirstName());
        res.setLastName(emp.getLastName());
        res.setEmail(emp.getEmail());
        return res;
    }
}
