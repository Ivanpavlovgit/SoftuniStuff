package com.example.dtodemo.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class EmployeeDto  extends BasicEmployeeDto{
@Expose
    private BigDecimal income;

    public EmployeeDto () {
    }


    public BigDecimal getIncome () {
        return this.income;
    }

    public EmployeeDto setIncome (BigDecimal salary) {
        this.income = salary;
        return this;
    }
}
