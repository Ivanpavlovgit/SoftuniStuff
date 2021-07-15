package com.example.gameshop.Model.Dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {

    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailURL;
    private String description;
    private String releaseDate;

    @Pattern(regexp = "[A-Z][a-z]{3,100}",
            message = "Enter valid title between 3 and 100 symbols")
    public String getTitle () {
        return this.title;
    }

    public GameAddDto setTitle (String title) {
        this.title = title;
        return this;
    }

    @DecimalMin(value = "0",
            message = "Enter valid positive price")
    public BigDecimal getPrice () {
        return this.price;
    }

    public GameAddDto setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    @Positive()
    public Double getSize () {
        return this.size;
    }

    public GameAddDto setSize (Double size) {
        this.size = size;
        return this;
    }

    @Size(min = 11, max = 11,
            message = "Enter valid trailer URL id")
    public String getTrailer () {
        return this.trailer;
    }

    public GameAddDto setTrailer (String trailer) {
        this.trailer = trailer;
        return this;
    }

    @Pattern(regexp = "https?.+",
            message = "Enter valid trailer URL http or https")
    public String getThumbnailURL () {
        return this.thumbnailURL;
    }

    public GameAddDto setThumbnailURL (String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
        return this;
    }

    public String getDescription () {
        return this.description;
    }

    @Size(min = 20,
            message = "Enter valid description larger than 20 chars")
    public GameAddDto setDescription (String description) {
        this.description = description;
        return this;
    }

    public String getReleaseDate () {
        return this.releaseDate;
    }

    public GameAddDto setReleaseDate (String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public GameAddDto () {
    }

}
