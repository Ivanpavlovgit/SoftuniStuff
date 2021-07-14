package com.example.gameshop.Model.Entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId () {
        return this.id;
    }

    public BaseEntity setId (Long id) {
        this.id = id;
        return this;
    }

    public BaseEntity () {
    }
}
