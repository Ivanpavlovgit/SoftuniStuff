package com.example.json_exc.model.Dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class UserSeedDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;

    public String getFirstName () {
        return this.firstName;
    }

    public UserSeedDto setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Size(min = 3)
    public String getLastName () {
        return this.lastName;
    }

    public UserSeedDto setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge () {
        return this.age;
    }

    public UserSeedDto setAge (Integer age) {
        this.age = age;
        return this;
    }

    public UserSeedDto () {
    }
}
