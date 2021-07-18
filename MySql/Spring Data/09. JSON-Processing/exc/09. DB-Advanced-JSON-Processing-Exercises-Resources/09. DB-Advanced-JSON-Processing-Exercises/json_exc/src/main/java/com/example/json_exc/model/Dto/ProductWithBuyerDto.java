package com.example.json_exc.model.Dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductWithBuyerDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String buyerFirstName;
    @Expose
    private String buyerLastName;

    public String getName () {
        return this.name;
    }

    public ProductWithBuyerDto setName (String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice () {
        return this.price;
    }

    public ProductWithBuyerDto setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getBuyerFirstName () {
        return this.buyerFirstName;
    }

    public ProductWithBuyerDto setBuyerFirstName (String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
        return this;
    }

    public String getBuyerLastName () {
        return this.buyerLastName;
    }

    public ProductWithBuyerDto setBuyerLastName (String buyerLastName) {
        this.buyerLastName = buyerLastName;
        return this;
    }

    public ProductWithBuyerDto () {
    }
}
