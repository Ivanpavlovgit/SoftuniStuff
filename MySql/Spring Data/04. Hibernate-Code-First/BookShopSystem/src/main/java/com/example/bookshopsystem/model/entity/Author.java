package com.example.bookshopsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
    private String firstName;
    private String lastName;

    public Author () {
    }

    @Column(name = "first_name")
    public String getFirstName () {
        return this.firstName;
    }

    public Author setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName () {
        return this.lastName;
    }

    public Author setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }
}
