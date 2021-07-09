package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
    private String firstName;
    private String lastName;
    private Set<Book> books;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    public Set<Book> getBooks () {
        return this.books;
    }

    public Author setBooks (Set<Book> books) {
        this.books = books;
        return this;
    }

    public Author (String firstName,String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Author () {
    }
}
