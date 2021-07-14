package com.example.gameshop.Model.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String email;
    private String password;
    private String fullName;
    private Set<Game> games;
    private boolean isAdmin;
@Column
    public boolean isAdmin () {
        return this.isAdmin;
    }

    public User setAdmin (boolean admin) {
        isAdmin = admin;
        return this;
    }

    @ManyToMany
    public Set<Game> getGames () {
        return this.games;
    }

    public User setGames (Set<Game> games) {
        this.games = games;
        return this;
    }

    @Column(name = "email")
    public String getEmail () {
        return this.email;
    }

    public User setEmail (String email) {
        this.email = email;
        return this;
    }

    @Column(name = "password")
    public String getPassword () {
        return this.password;
    }

    public User setPassword (String password) {
        this.password = password;
        return this;
    }

    @Column(name = "full_name")
    public String getFullName () {
        return this.fullName;
    }

    public User setFullName (String fullName) {
        this.fullName = fullName;
        return this;
    }

    public User () {
    }
}
