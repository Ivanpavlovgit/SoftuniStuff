package com.example.json_exc.model.Dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserSoldDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductWithBuyerDto> products;

    public Set<ProductWithBuyerDto> getProducts () {
        return this.products;
    }

    public UserSoldDto setProducts (Set<ProductWithBuyerDto> products) {
        this.products = products;
        return this;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public UserSoldDto setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName () {
        return this.lastName;
    }

    public UserSoldDto setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserSoldDto () {
    }
}
