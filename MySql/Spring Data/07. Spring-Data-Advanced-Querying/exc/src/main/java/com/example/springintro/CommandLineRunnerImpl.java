package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl (CategoryService categoryService,AuthorService authorService,BookService bookService,BufferedReader reader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = reader;
    }

    @Override
    public void run (String... args) throws Exception {
        seedData ();


        System.out.println ("Hello !");
        System.out.println ("Exercises: Spring Data Advanced Querying");


        System.out.println ("Do you want to select a task (YES/NO)");
        String input = reader.readLine ();
        while (!input.equalsIgnoreCase ("NO")) {
            if (input.equalsIgnoreCase ("YES")) {
                System.out.println ("Select task number");
                int taskNum = Integer.parseInt (reader.readLine ());
                switch (taskNum) {
                    case 1 -> task1 ();
                    case 2 -> task2 ();
                    case 3 -> task3 ();
                    case 4 -> task4 ();
                    case 5 -> task5 ();
                    case 6 -> task6 ();
                    case 7 -> task7 ();
                    case 8 -> task8 ();
                    case 9 -> task9 ();
                    case 10 -> task10 ();
                    case 11 -> task11 ();
                    case 12 -> task12 ();
                    case 13 -> task13 ();

                }
                System.out.println ("Do you want to select another task (YES/NO)");
            } else {
                System.out.println ("Incorrect input");
                System.out.println ("Please write YES,NO or a task number (int)");
            }
            input = reader.readLine ();

        }
        System.out.println ("Hope you had fun with our UX !");
        System.out.println ("Have a nice and bug free day !");

    }

    private void task1 () throws IOException {
        System.out.println ("1.Books Titles by Age Restriction");
        System.out.println ("Enter age restriction");
        var ageRestriction = AgeRestriction.valueOf (reader.readLine ().toUpperCase ());

        bookService
                .findAllBookTitlesWithAgeRestriction (ageRestriction)
                .forEach (System.out::println);

    }

    private void task2 () {
        System.out.println ("2.Golden Books");
        bookService.findAllGoldBookTitlesWithLessThan5000 ()
                .forEach (System.out::println);
    }

    private void task3 () {
        System.out.println ("3.Books by Price");
        var result = bookService.findAllBookTitlesAndPricesNotBetween5And40 ();
        result.forEach (System.out::println);
        System.out.printf ("%d Books found.%n",result.size ());
    }

    private void task4 () throws IOException {
        System.out.println ("4.Not Released Books");
        System.out.println ("Enter an year (int) to find books that are not released in that year");

        var year = Integer.parseInt (reader.readLine ());

        this.bookService
                .findAllBookTitlesNotReleasedInTheGivenYear (year)
                .forEach (System.out::println);
    }

    private void task5 () throws IOException {
        System.out.println ("5.Books Released Before Date");
        System.out.println ("Enter date in format dd-MM-yyyy");
        var date = LocalDate.parse (reader.readLine (),DateTimeFormatter.ofPattern ("dd-MM-yyyy"));
        bookService
                .findAllBooksWithReleaseDateAfterDate (date)
                .forEach (System.out::println);
    }

    private void task6 () throws IOException {
        System.out.println ("6.Authors Search");
        System.out.println ("Enter a char sequence with which the authors first name must end ");
        var charsToEndWith = reader.readLine ();

        this.authorService
                .findAllAuthorsWhichHaveFirstNameEndingWith (charsToEndWith)
                .forEach (System.out::println);
    }

    private void task7 () throws IOException {
        System.out.println ("7.Books Search");
        System.out.println ("Enter a string to search in book titles (case insensitive)");
        var str = reader.readLine ();
        this.bookService
                .findAllBooksWithTitlesIncluding (str)
                .forEach (System.out::println);
    }

    private void task8 () throws IOException {
        System.out.println ("8.Book Titles Search");
        System.out.println ("Enter a string for a start of last name of the authors whose book you like to find");

        var str = reader.readLine ();

        bookService
                .findAllBooksWithAuthorWithLastNameStartingWith (str)
                .forEach (System.out::println);


    }

    private void task9 () throws IOException {
        System.out.println ("9.Count Books");
        System.out.println ("Enter criteria (int) for length or book titles");
        var length = Integer.parseInt (reader.readLine ());

        System.out.println (bookService
                .findCountOfBooksWithTitlesLongerThan (length));
    }

    private void task10 () throws IOException {
        System.out.println ("10.Total Book Copies");

        this.authorService
                .getAllAuthorsOrderedByTotalBookCopies ()
                .forEach (System.out::println);
    }

    private void task11 () throws IOException {
        System.out.println ("11.Reduced Book");
        System.out.println ("Enter Book Title");
        var bookTitle = reader.readLine ();
        System.out.println (bookService.getReducedInformationAboutBookByTitle (bookTitle));
    }

    private void task12 () {
        System.out.println ("12.* Increase Book Copies");
    }

    private void task13 () {
        System.out.println ("13.* Remove Books");
    }


    private void printALlBooksByAuthorNameOrderByReleaseDate (String firstName,String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate (firstName,lastName)
                .forEach (System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks () {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks ()
                .forEach (System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear (int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear (year)
                .forEach (System.out::println);
    }

    private void printAllBooksAfterYear (int year) {
        bookService
                .findAllBooksAfterYear (year)
                .stream ()
                .map (Book::getTitle)
                .forEach (System.out::println);
    }

    private void seedData () throws IOException {
        categoryService.seedCategories ();
        authorService.seedAuthors ();
        bookService.seedBooks ();
    }
}
