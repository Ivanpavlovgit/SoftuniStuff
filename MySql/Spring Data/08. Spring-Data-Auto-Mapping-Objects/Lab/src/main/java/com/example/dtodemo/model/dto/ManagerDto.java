package com.example.dtodemo.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ManagerDto extends BasicEmployeeDto {
    @Expose
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates () {
        return this.subordinates;
    }

    public ManagerDto setSubordinates (List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
        return this;
    }
}
