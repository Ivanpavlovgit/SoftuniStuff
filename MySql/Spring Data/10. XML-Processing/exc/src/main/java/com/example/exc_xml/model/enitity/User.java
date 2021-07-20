package com.example.exc_xml.model.enitity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private Integer age;
    private Set<User> friends;
    private Set<Product> products;

    @Column(name = "first_name")
    public String getFirstName () {
        return this.firstName;
    }

    public User setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName () {
        return this.lastName;
    }

    public User setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column
    public Integer getAge () {
        return this.age;
    }

    public User setAge (Integer age) {
        this.age = age;
        return this;
    }

    @ManyToMany
    public Set<User> getFriends () {
        return this.friends;
    }

    public User setFriends (Set<User> friends) {
        this.friends = friends;
        return this;
    }

    public User () {
    }
@OneToMany(mappedBy = "seller",fetch = FetchType.EAGER)
    public Set<Product> getProducts () {
        return this.products;
    }

    public User setProducts (Set<Product> products) {
        this.products = products;
        return this;
    }
}
