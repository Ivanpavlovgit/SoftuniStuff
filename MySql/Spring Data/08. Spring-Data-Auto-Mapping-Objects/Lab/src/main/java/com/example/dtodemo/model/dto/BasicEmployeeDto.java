package com.example.dtodemo.model.dto;

import com.google.gson.annotations.Expose;

public abstract class BasicEmployeeDto {
    @Expose
    private String firstName;
    @Expose
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
