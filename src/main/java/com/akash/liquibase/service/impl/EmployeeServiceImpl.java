package com.akash.liquibase.service.impl;

import com.akash.liquibase.dto.EmployeeRequest;
import com.akash.liquibase.dto.EmployeeResponse;
import com.akash.liquibase.service.EmployeeService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @author Akash Kumar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {

        String sql = "INSERT INTO EMPLOYEE (NAME, PHONE, EMAIL, UNDER_SURVEILLANCE, CRIMINAL_RECORD) " +
                "VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employeeRequest.getName());
            ps.setString(2, employeeRequest.getMobile());
            ps.setString(3, employeeRequest.getEmail());
            ps.setBoolean(4, false);
            ps.setBoolean(5, false);
            return ps;
        }, keyHolder);

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setName(employeeRequest.getName());
        employeeResponse.setPhone(employeeRequest.getMobile());
        employeeResponse.setEmail(employeeRequest.getEmail());

        return employeeResponse;
    }
}
