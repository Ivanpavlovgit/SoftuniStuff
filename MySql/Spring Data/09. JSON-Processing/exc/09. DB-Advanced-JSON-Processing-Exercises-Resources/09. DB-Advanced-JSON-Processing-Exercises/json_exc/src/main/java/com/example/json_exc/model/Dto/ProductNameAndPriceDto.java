package com.example.json_exc.model.Dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductNameAndPriceDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String seller;

    public String getName () {
        return this.name;
    }

    public ProductNameAndPriceDto setName (String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice () {
        return this.price;
    }

    public ProductNameAndPriceDto setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSeller () {
        return this.seller;
    }

    public ProductNameAndPriceDto setSeller (String seller) {
        this.seller = seller;
        return this;
    }

    public ProductNameAndPriceDto () {
    }
}
