package com.akash.liquibase.controller;

import com.akash.liquibase.dto.EmployeeRequest;
import com.akash.liquibase.dto.EmployeeResponse;
import com.akash.liquibase.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akash Kumar
 */
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/api/v1/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/v1/employee")
    public ResponseEntity<Object> getEmployee(){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
}
