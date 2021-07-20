package com.example.exc_xml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedRootDto {
    @XmlElement(name="products")
    private List<ProductSeedDto> products;

    public List<ProductSeedDto> getProducts () {
        return this.products;
    }

    public ProductSeedRootDto setProducts (List<ProductSeedDto> products) {
        this.products = products;
        return this;
    }

    public ProductSeedRootDto () {
    }
}
