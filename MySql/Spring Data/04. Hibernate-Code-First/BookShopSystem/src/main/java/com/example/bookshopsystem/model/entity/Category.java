package com.example.bookshopsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
    private String name;

    public Category () {
    }
@Column(name="name",nullable = false,unique = true)
    public String getName () {
        return this.name;
    }

    public Category setName (String name) {
        this.name = name;
        return this;
    }
}
