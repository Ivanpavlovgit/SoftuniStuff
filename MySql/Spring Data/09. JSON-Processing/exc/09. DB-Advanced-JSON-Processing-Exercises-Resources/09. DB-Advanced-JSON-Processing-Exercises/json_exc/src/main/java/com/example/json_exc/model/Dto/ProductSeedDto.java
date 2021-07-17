package com.example.json_exc.model.Dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    @Size(min = 3, max = 15)
    public String getName () {
        return this.name;
    }

    public ProductSeedDto setName (String name) {
        this.name = name;
        return this;
    }

    @Positive
    public BigDecimal getPrice () {
        return this.price;
    }

    public ProductSeedDto setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductSeedDto () {
    }
}
