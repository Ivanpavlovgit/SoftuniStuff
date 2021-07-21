package com.example.exc_xml.model.enitity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private BigDecimal price;
    private User seller;
    private Set<Category> categories;
    private User buyer;
    public Product () {

    }

    @Column
    public String getName () {
        return this.name;
    }

    public Product setName (String name) {
        this.name = name;
        return this;
    }

    @Column
    public BigDecimal getPrice () {
        return this.price;
    }

    public Product setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    @ManyToOne
    public User getSeller () {
        return this.seller;
    }

    public Product setSeller (User seller) {
        this.seller = seller;
        return this;
    }

    @ManyToOne
    public User getBuyer () {
        return this.buyer;
    }

    public Product setBuyer (User buyer) {
        this.buyer = buyer;
        return this;
    }

    @ManyToMany
    public Set<Category> getCategories () {
        return this.categories;
    }

    public Product setCategories (Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
