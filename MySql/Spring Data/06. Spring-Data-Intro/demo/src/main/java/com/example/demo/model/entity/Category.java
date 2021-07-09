package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;

    public Category (String categoryName) {
        this.name = categoryName;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName () {
        return this.name;
    }

    public Category setName (String name) {
        this.name = name;
        return this;
    }

    public Category () {
    }


    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass () != o.getClass ()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals (name,category.name);
    }

    @Override
    public int hashCode () {
        return Objects.hash (name);
    }
}
