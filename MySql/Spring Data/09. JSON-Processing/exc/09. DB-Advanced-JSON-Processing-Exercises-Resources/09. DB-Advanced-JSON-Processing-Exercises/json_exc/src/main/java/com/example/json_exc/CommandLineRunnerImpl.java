package com.example.json_exc;

import com.example.json_exc.service.CategoryService;
import com.example.json_exc.service.ProductService;
import com.example.json_exc.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
private final CategoryService categoryService;
private final ProductService productService;
private final UserService userService;
    public CommandLineRunnerImpl (CategoryService categoryService,ProductService productService,UserService userService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run (String... args) throws Exception {
        seedData();
        System.out.println ("ok");
    }

    private void seedData () throws IOException {
        this.categoryService.seedCategories();
        this.userService.seedUsers();
        this.productService.seedProducts();
    }
}
