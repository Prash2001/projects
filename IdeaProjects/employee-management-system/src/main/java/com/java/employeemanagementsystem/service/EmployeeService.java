package com.java.employeemanagementsystem.service;

import com.java.employeemanagementsystem.model.EmployeeRequest;
import com.java.employeemanagementsystem.model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployees();
}
