package com.akash.liquibase.service;

import com.akash.liquibase.dto.EmployeeRequest;
import com.akash.liquibase.dto.EmployeeResponse;

import java.util.List;

/**
 * @author Akash Kumar
 */
public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getEmployee();
}
