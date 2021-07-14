package com.example.gameshop.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    private String title;
    private String trailer;
    private String imageThumbnail;
    private Double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    @Column(name = "title")
    public String getTitle () {
        return this.title;
    }

    public Game setTitle (String title) {
        this.title = title;
        return this;
    }
    @Column(name = "trailer")
    public String getTrailer () {
        return this.trailer;
    }

    public Game setTrailer (String trailer) {
        this.trailer = trailer;
        return this;
    }
    @Column(name = "immage_thumbnail")
    public String getImageThumbnail () {
        return this.imageThumbnail;
    }

    public Game setImageThumbnail (String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
        return this;
    }
    @Column(name = "size")
    public Double getSize () {
        return this.size;
    }

    public Game setSize (Double size) {
        this.size = size;
        return this;
    }
    @Column(name = "price")
    public BigDecimal getPrice () {
        return this.price;
    }

    public Game setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }
    @Column(name = "description",columnDefinition = "TEXT")
    public String getDescription () {
        return this.description;
    }

    public Game setDescription (String description) {
        this.description = description;
        return this;
    }
    @Column(name = "release_date")
    public LocalDate getReleaseDate () {
        return this.releaseDate;
    }

    public Game setReleaseDate (LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Game () {
    }
}
