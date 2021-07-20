package com.example.exc_xml.model.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedDto {
    @XmlElement
    private String name;
@Size(min = 3,max = 15)
    public String getName () {
        return this.name;
    }

    public CategorySeedDto setName (String name) {
        this.name = name;
        return this;
    }

    public CategorySeedDto () {
    }
}
