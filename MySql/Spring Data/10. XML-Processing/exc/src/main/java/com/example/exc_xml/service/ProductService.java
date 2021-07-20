package com.example.exc_xml.service;


import com.example.exc_xml.model.dto.ProductSeedDto;

import java.util.List;

public interface ProductService {

    long getCount ();

    void seedProducts (List<ProductSeedDto> products);
}
