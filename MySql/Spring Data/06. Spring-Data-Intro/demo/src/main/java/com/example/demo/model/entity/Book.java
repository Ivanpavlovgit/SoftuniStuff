package com.example.demo.model.entity;

import com.example.demo.model.entity.enums.AgeRestriction;
import com.example.demo.model.entity.enums.EditionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;
    private AgeRestriction ageRestriction;
    private Author author;
    private Set<Category> categories;


    @ManyToOne
    public Author getAuthor () {
        return this.author;
    }

    public Book setAuthor (Author author) {
        this.author = author;
        return this;
    }

    @ManyToMany
    public Set<Category> getCategories () {
        return this.categories;
    }

    public Book setCategories (Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    @Column(name = "title", length = 50, nullable = false)
    public String getTitle () {
        return this.title;
    }

    public Book setTitle (String title) {
        this.title = title;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT",nullable = true)
    public String getDescription () {
        return this.description;
    }

    public Book setDescription (String description) {
        this.description = description;
        return this;
    }

    @Enumerated()
    public EditionType getEditionType () {
        return this.editionType;
    }

    public Book setEditionType (EditionType editionType) {
        this.editionType = editionType;
        return this;
    }

    @Column(name = "price")
    public BigDecimal getPrice () {
        return this.price;
    }

    public Book setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "copies")
    public Integer getCopies () {
        return this.copies;
    }

    public Book setCopies (Integer copies) {
        this.copies = copies;
        return this;
    }

    @Column(name = "release_date")
    public LocalDate getReleaseDate () {
        return this.releaseDate;
    }

    public Book setReleaseDate (LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Enumerated()
    public AgeRestriction getAgeRestriction () {
        return this.ageRestriction;
    }

    public Book setAgeRestriction (AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    public Book () {
    }
}
