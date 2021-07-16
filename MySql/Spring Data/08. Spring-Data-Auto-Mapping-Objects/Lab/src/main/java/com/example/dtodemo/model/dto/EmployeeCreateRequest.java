package com.example.dtodemo.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class EmployeeCreateRequest extends BasicEmployeeDto {
    @Expose
    private BigDecimal salary;
    @Expose
    private String address;

    public BigDecimal getSalary () {
        return this.salary;
    }

    public EmployeeCreateRequest setSalary (BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public String getAddress () {
        return this.address;
    }

    public EmployeeCreateRequest setAddress (String address) {
        this.address = address;
        return this;
    }

    public EmployeeCreateRequest () {
    }
}
