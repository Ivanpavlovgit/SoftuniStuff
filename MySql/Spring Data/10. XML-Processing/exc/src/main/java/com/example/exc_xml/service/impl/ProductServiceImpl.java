package com.example.exc_xml.service.impl;

import com.example.exc_xml.model.dto.ProductSeedDto;
import com.example.exc_xml.model.dto.ProductViewRootDto;
import com.example.exc_xml.model.dto.ProductWithSellerDto;
import com.example.exc_xml.model.enitity.Product;
import com.example.exc_xml.repository.ProductsRepository;
import com.example.exc_xml.service.CategoryService;
import com.example.exc_xml.service.ProductService;

import com.example.exc_xml.service.UserService;
import com.example.exc_xml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl (ProductsRepository productsRepository,ModelMapper modelMapper,ValidationUtil validationUtil,UserService userService,CategoryService categoryService) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
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
                .map (productSeedDto -> {
                    Product product = modelMapper.map (productSeedDto,Product.class);
                    product.setSeller (this.userService.getRandomUser ());
                    if (product.getPrice ().compareTo (BigDecimal.valueOf (700L)) > 0) {
                        product.setBuyer (userService.getRandomUser ());
                    }
                    product.setCategories (this.categoryService.getRandomCategories ());
                    return product;
                })
                .forEach (productsRepository::save);

        //todo:: dotuka nqkude sme
    }

    @Override
    public ProductViewRootDto findProductsInRangeWithNoBuyer () {
        ProductViewRootDto productViewRootDto =
                new ProductViewRootDto ();
        productViewRootDto
                .setProducts (this.productsRepository
                        .findAllByPriceBetweenAndBuyerIsNull (
                                BigDecimal.valueOf (500L),
                                BigDecimal.valueOf (1000L))
                        .stream ()
                        .map (product -> {
                            ProductWithSellerDto productWithSellerDto = modelMapper.map (
                                    product,ProductWithSellerDto.class);
                            productWithSellerDto
                                    .setSeller (String.format ("%s %s",
                                    product.getSeller ().getFirstName (),
                                    product.getSeller ().getLastName ()));

                            return productWithSellerDto;
                        })
                        .collect (Collectors.toList ()));


        return productViewRootDto;
    }
}
