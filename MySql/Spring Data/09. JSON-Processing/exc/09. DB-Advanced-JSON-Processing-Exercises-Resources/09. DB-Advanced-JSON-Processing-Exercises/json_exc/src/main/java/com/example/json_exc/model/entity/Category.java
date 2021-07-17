package com.example.json_exc.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private Set<Product> products;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Product> getProducts () {
        return this.products;
    }

    public Category setProducts (Set<Product> products) {
        this.products = products;
        return this;
    }

    @Column(length = 15, nullable = false, unique = true)
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
        return Objects.equals (name,category.name) && Objects.equals (products,category.products);
    }

    @Override
    public int hashCode () {
        return Objects.hash (name,products);
    }
}
