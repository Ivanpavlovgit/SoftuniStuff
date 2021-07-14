package com.example.gameshop.Model.Entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private User buyer;
    private Set<Game> games;

    @ManyToOne
    public User getBuyer () {
        return this.buyer;
    }

    public Order setBuyer (User buyer) {
        this.buyer = buyer;
        return this;
    }

    @ManyToMany
    public Set<Game> getGames () {
        return this.games;
    }

    public Order setGames (Set<Game> games) {
        this.games = games;
        return this;
    }

    public Order () {
    }
}
