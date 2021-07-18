package com.example.json_exc.service.impl;

import com.example.json_exc.consts.GlobalConstants;
import com.example.json_exc.model.Dto.ProductNameAndPriceDto;
import com.example.json_exc.model.Dto.ProductSeedDto;
import com.example.json_exc.model.entity.Product;
import com.example.json_exc.repository.ProductsRepository;
import com.example.json_exc.service.CategoryService;
import com.example.json_exc.service.ProductService;
import com.example.json_exc.service.UserService;
import com.example.json_exc.utilities.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    public static final String PRODUCTS_FILE_NAME = "products.json";

    public ProductServiceImpl (ProductsRepository productsRepository,ModelMapper modelMapper,Gson gson,ValidationUtil validationUtil,UserService userService,CategoryService categoryService) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts () throws IOException {
        if (this.productsRepository.count () == 0) {
            var productsJSONAsString = Files
                    .readString (Path.of (GlobalConstants.FIRST_TASK_FOLDER_PATH + PRODUCTS_FILE_NAME));

            ProductSeedDto[] productSeedDtos = this.gson
                    .fromJson (productsJSONAsString,ProductSeedDto[].class);
            Arrays.stream (productSeedDtos)
                    .filter (validationUtil::isValid)
                    .map (productSeedDto -> {
                        var product = modelMapper.map (productSeedDto,Product.class);
                        product.setSeller (this.userService.findRandomUser ());
                        if (productSeedDto.getPrice ().compareTo (BigDecimal.valueOf (500L)) > 0) {
                            product.setBuyer (this.userService.findRandomUser ());
                        }
                        product.setCategories (this.categoryService.findRandomCategoriesSet ());

                        return product;
                    }).forEach (this.productsRepository::save);
        }
    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderedByPrice (BigDecimal lower,BigDecimal upper) {
        return productsRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc (lower,upper)
                .stream ()
                .map (product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper
                            .map (product,ProductNameAndPriceDto.class);

                    productNameAndPriceDto.setSeller (String.format ("%s %s",
                            product.getSeller ().getFirstName (),
                            product.getSeller ().getLastName ()));

                    return productNameAndPriceDto;
                })
                .collect (Collectors.toList ());
    }
}
