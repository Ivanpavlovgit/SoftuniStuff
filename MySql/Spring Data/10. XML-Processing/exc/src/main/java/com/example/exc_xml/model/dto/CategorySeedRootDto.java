package com.example.exc_xml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedRootDto {
    @XmlElement(name="category")
    private List<CategorySeedDto> categories;

    public List<CategorySeedDto> getCategories () {
        return this.categories;
    }

    public CategorySeedRootDto setCategories (List<CategorySeedDto> categories) {
        this.categories = categories;
        return this;
    }

    public CategorySeedRootDto () {
    }
}
