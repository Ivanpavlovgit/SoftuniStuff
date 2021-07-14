package com.example.dtodemo.model.dto;

public abstract class BasicEmployeeDto {
    private String firstName;
    private String lastName;

    public String getFirstName () {
        return this.firstName;
    }

    public BasicEmployeeDto setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName () {
        return this.lastName;
    }

    public BasicEmployeeDto setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }
}
