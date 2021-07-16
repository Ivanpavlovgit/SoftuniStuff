package com.example.dtodemo.model.dto;

import com.google.gson.annotations.Expose;

public class EmployeeCreateResponse  extends EmployeeCreateRequest{
    @Expose
    private Long id;

    public Long getId () {
        return this.id;
    }

    public EmployeeCreateResponse setId (Long id) {
        this.id = id;
        return this;
    }
}
