package com.example.shamp;

import com.example.shamp.entities.Shampoo;
import com.example.shamp.entities.Size;
import com.example.shamp.service.IngredientService;
import com.example.shamp.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class Main implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    private final BufferedReader reader;

    public Main (ShampooService shampooService,IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.reader = new BufferedReader (new InputStreamReader (System.in));
    }

    @Override
    public void run (String... args) throws Exception {
        System.out.println ("Hello !");
        System.out.println ("Please, select task: ");
        var input = reader.readLine ();
        switch (input) {
            case "1" -> task1 ();
            case "2" -> task2 ();
            case "3" -> task3 ();
            case "4" -> task4 ();
            case "5" -> task5 ();
            case "6" -> task6 ();
            case "7" -> task7 ();
            case "8" -> task8 ();
            case "9" -> task9 ();
            case "10" -> task10 ();
            case "11" -> task11 ();
        }

    }

    private void task11 () throws IOException {
        System.out.println ("Task 11: ");
        System.out.println ("Please enter Name to update ingredients: ");
        var names=Arrays.asList (reader.readLine ().split (", "));
        System.out.println ("Old prices were :");
        this.ingredientService.findAll ().forEach (ingredient -> {
            System.out.printf ("%s : %.2f%n",ingredient.getName (),ingredient.getPrice ());
        });
        this.ingredientService.updateIngredientsByNames (names);
        System.out.println ("New prices are : ");
        this.ingredientService.findAll ().forEach (ingredient -> {
            System.out.printf ("%s : %.2f%n",ingredient.getName (),ingredient.getPrice ());
        });
    }

    private void task10 () {
        System.out.println ("Task 10: ");
        System.out.println ("Old prices were :");
        this.ingredientService.findAll ().forEach (ingredient -> {
            System.out.printf ("%s : %.2f%n",ingredient.getName (),ingredient.getPrice ());
        });
        this.ingredientService.updatePriceOfAll ();
        this.ingredientService.findAll ().forEach (ingredient -> {
            System.out.println (ingredient.getPrice ());
        });
        System.out.println ("New prices are :");
        this.ingredientService.findAll ().forEach (ingredient -> {
            System.out.printf ("%s : %.2f%n",ingredient.getName (),ingredient.getPrice ());
        });
    }

    private void task9 () throws IOException {
        System.out.println ("Task 9: ");
        System.out.println ("Please, enter name to delete: ");
        var name = reader.readLine ();
        this.ingredientService
                .deleteAllByName (name);
        System.out.println ("Deleted" + name);
    }

    private void task8 () throws IOException {
        System.out.println ("Task 8: ");
        System.out.println ("Please, enter ingredient count: ");
        var count = Long.parseLong (reader.readLine ());

        this.shampooService
                .findAllByIngredientsCounts (count)
                .forEach (System.out::println);

    }

    private void task7 () throws IOException {
        System.out.println ("Task 7: ");
        System.out.println ("Please, enter names: ");
        var names = Arrays.asList (
                reader.readLine ()
                        .split ("\\s+"));

        this.shampooService
                .findAllByIngredientsNames (names)
                .forEach (System.out::println);
    }

    private void task6 () throws IOException {
        System.out.println ("Task 6: ");
        System.out.println ("Please, enter price: ");
        var price = new BigDecimal (reader.readLine ());
        System.out.println (this.shampooService
                .countAllByPriceLessThan (price));

    }

    private void task5 () throws IOException {
        System.out.println ("Task 5: ");
        System.out.println ("Please, enter name collection to filter ingredients win it: ");
        var name = Arrays.asList (reader.readLine ().split ("\\s+"));
        this.ingredientService
                .findAllByNameIn (name)
                .forEach (System.out::println);
    }

    private void task4 () throws IOException {
        System.out.println ("Task 4: ");
        System.out.println ("Please, enter characters to filter ingredients to start with: ");
        var name = reader.readLine ();
        this.ingredientService
                .findAllByNameStartingWith (name)
                .forEach (System.out::println);
    }

    private void task3 () throws IOException {
        System.out.println ("Task 3: ");
        System.out.println ("Please, enter price to filter by(floating point number): ");
        var price = new BigDecimal (reader.readLine ());
        this.shampooService
                .findAllByPriceGreaterThanOrderByPriceDesc (price)
                .forEach (System.out::println);
    }

    private void task2 () throws IOException {
        System.out.println ("Task 2: ");
        System.out.println ("Please, enter size (SMALL,MEDIUM,LARGE): ");
        var size = Size.valueOf (reader.readLine ());
        System.out.println ("Please, enter label Id (Long): ");
        var labelId = Long.parseLong (reader.readLine ());
        this.shampooService
                .findAllBySizeOrLabelOrderByPrice (size,labelId)
                .forEach (System.out::println);
    }

    private void task1 () throws IOException {
        System.out.println ("Task 1: ");
        System.out.println ("Please, enter size (SMALL,MEDIUM,LARGE): ");

        var size = Size.valueOf (reader.readLine ());

        this.shampooService
                .findAllBySizeOrderById (size)
                .forEach (System.out::println);
    }
}
