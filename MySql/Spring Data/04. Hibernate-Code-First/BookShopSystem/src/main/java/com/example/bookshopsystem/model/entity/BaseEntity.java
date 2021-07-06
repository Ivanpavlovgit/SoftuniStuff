package com.example.bookshopsystem.model.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
private Long id;

    public BaseEntity () {
    }

    public Long getId () {
        return this.id;
    }

    public BaseEntity setId (Long id) {
        this.id = id;
        return this;
    }
}
