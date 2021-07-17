package com.example.json_exc.model.Dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Size;

public class CategorySeedDto {
    @Expose
    private String name;

    @Size(min = 3, max = 15)
    public String getName () {
        return this.name;
    }

    public CategorySeedDto setName (String name) {
        this.name = name;
        return this;
    }

    public CategorySeedDto () {
    }
}
