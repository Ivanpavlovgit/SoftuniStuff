package com.example.dtodemo.model.dto;

import java.math.BigDecimal;

public class EmployeeDto  extends BasicEmployeeDto{

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
