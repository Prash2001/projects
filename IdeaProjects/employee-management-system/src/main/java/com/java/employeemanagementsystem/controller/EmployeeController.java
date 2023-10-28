package com.java.employeemanagementsystem.controller;

import com.java.employeemanagementsystem.model.EmployeeRequest;
import com.java.employeemanagementsystem.model.EmployeeResponse;
import com.java.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    final private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.createEmployee(employeeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
