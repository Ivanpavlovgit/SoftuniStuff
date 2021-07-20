package com.example.exc_xml.service.impl;

import com.example.exc_xml.model.dto.ProductSeedDto;
import com.example.exc_xml.model.enitity.Product;
import com.example.exc_xml.repository.ProductsRepository;
import com.example.exc_xml.service.ProductService;

import com.example.exc_xml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl (ProductsRepository productsRepository,ModelMapper modelMapper,ValidationUtil validationUtil) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount () {
        return this.productsRepository.count ();
    }

    @Override
    public void seedProducts (List<ProductSeedDto> products) {

        products
                .stream ()
                .filter (validationUtil::isValid)
                .map (productSeedDto -> modelMapper.map (productSeedDto,Product.class))
                .forEach (productsRepository::save);

        //todo:: dotuka nqkude sme
    }
}
