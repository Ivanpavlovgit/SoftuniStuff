package com.example.json_exc.service;

import com.example.json_exc.model.Dto.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts () throws IOException;

    List<ProductNameAndPriceDto> findAllProductsInRangeOrderedByPrice (BigDecimal valueOf,BigDecimal valueOf1);
}
