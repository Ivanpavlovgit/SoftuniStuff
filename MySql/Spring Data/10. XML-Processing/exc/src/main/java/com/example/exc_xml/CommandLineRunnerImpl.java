package com.example.exc_xml;

import com.example.exc_xml.consts.GlobalConstants;
import com.example.exc_xml.model.dto.CategorySeedRootDto;
import com.example.exc_xml.model.dto.ProductSeedRootDto;
import com.example.exc_xml.model.dto.ProductViewRootDto;
import com.example.exc_xml.model.dto.UserSeedRootDto;
import com.example.exc_xml.service.CategoryService;
import com.example.exc_xml.service.ProductService;
import com.example.exc_xml.service.UserService;
import com.example.exc_xml.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader reader;
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private ProductService productService;

    public CommandLineRunnerImpl (BufferedReader reader,XmlParser xmlParser,CategoryService categoryService,UserService userService,ProductService productService) {
        this.reader = reader;
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run (String... args) throws Exception {
        seedData ();


        System.out.println ("Hello !");
        System.out.println ("Exercises: XML Processing");


        System.out.println ("Do you want to select a task (YES/NO)");
        String input = reader.readLine ();
        while (!input.equalsIgnoreCase ("NO")) {
            if (input.equalsIgnoreCase ("YES")) {
                System.out.println ("Select task number (starting from 2)");
                int taskNum = Integer.parseInt (reader.readLine ());
                switch (taskNum) {
                    case 2 -> task2 ();

                }
                System.out.println ("Do you want to select another task (YES/NO)");
            } else {
                System.out.println ("Incorrect input");
                System.out.println ("Please write YES,NO or a task number (int)");
            }
            input = reader.readLine ();

        }
        System.out.println ("Goodbye ! Hope you had fun with our UX !");
        System.out.println ("Have a nice and bug free day !");

    }

    private void task2 () throws JAXBException {
        System.out.println ("You have selected Products in Range task");
        ProductViewRootDto productViewRootDto =
                this.productService
                        .findProductsInRangeWithNoBuyer ();

        xmlParser.writeToFile (GlobalConstants.OUTPUT_FILE_PATH + "2ndTask.xml",productViewRootDto);
    }


    private void seedData () throws JAXBException, FileNotFoundException {
        if (this.categoryService.getCount () == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile (GlobalConstants.RESOURCES_FILE_PATH + GlobalConstants.CATEGORIES_FILE_NAME,
                    CategorySeedRootDto.class);
            this.categoryService.seedCategories (categorySeedRootDto.getCategories ());
        }
        if (this.userService.getCount () == 0) {
            UserSeedRootDto userSeedRootDto = xmlParser.fromFile (GlobalConstants.RESOURCES_FILE_PATH + GlobalConstants.USERS_FILE_NAME,
                    UserSeedRootDto.class);
            this.userService.seedUsers (userSeedRootDto.getUsers ());
        }
        if (this.productService.getCount () == 0) {
            ProductSeedRootDto productSeedRootDto = xmlParser
                    .fromFile (GlobalConstants.RESOURCES_FILE_PATH +
                                    GlobalConstants.PRODUCTS_FILE_NAME,
                            ProductSeedRootDto.class);

            this.productService.seedProducts (productSeedRootDto.getProducts ());
        }
    }
}

