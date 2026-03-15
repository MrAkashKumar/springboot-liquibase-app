package com.akash.liquibase.dto;

/**
 * @author Akash Kumar
 * we can use lombok method also but now skipping
 */
public class EmployeeRequest {

    private String name;
    private String mobile;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
