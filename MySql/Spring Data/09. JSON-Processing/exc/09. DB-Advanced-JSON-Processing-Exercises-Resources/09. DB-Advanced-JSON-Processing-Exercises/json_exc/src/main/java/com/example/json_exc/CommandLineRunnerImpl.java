package com.example.json_exc;

import com.example.json_exc.consts.GlobalConstants;
import com.example.json_exc.model.Dto.ProductNameAndPriceDto;
import com.example.json_exc.model.Dto.UserSoldDto;
import com.example.json_exc.service.CategoryService;
import com.example.json_exc.service.ProductService;
import com.example.json_exc.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.imageio.stream.FileCacheImageInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;
    private final BufferedReader reader;
    private final Gson gson;

    public CommandLineRunnerImpl (CategoryService categoryService,ProductService productService,UserService userService,Gson gson) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.gson = gson;
        this.reader = new BufferedReader (new InputStreamReader (System.in));
    }

    @Override
    public void run (String... args) throws Exception {
        seedData ();
        System.out.println ("Welcome to Exercise: JSON Processing");
        System.out.println ("Enter task Number");
        int exNum = Integer.parseInt (reader.readLine ());
        switch (exNum) {
            case 1 -> productsInRange ();
            case 2 -> soldProducts ();
        }
    }

    private void soldProducts () {
      List<UserSoldDto> userSoldDtos =userService
                        .findAllUsersWithMoreThanOneSoldProduct();
    }

    private void productsInRange () throws IOException {
        System.out.println ("Selected task Query 1 – Products in Range");
        List<ProductNameAndPriceDto> productDtos =
                this.productService.findAllProductsInRangeOrderedByPrice (BigDecimal.valueOf (200L),BigDecimal.valueOf (1000L));
        String content = gson.toJson (productDtos);
        writeResultToFile (GlobalConstants.THIRD_TASK_OUTPUT,content);
        System.out.printf ("Successfully written %d records in %s!%n"
                ,productDtos.size (),GlobalConstants.THIRD_TASK_OUTPUT);
    }

    private void writeResultToFile (String filePath,String content) throws IOException {
        Files
                .write (Path.of (filePath),Collections.singleton (content));
    }

    private void seedData () throws IOException {
        this.categoryService.seedCategories ();
        this.userService.seedUsers ();
        this.productService.seedProducts ();
    }
}
