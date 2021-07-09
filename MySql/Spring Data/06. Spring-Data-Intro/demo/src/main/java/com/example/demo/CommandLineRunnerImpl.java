package com.example.demo;

import com.example.demo.model.entity.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl (CategoryService categoryService,AuthorService authorService,BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run (String... args) throws Exception {
        seedData ();

      /*  printAllBooksAfter2000 (2000);
        printAllAuthorsNamesWithBooksWithReleaseDateBefore1990 (1990);
        printAllAuthorsAndNumberOfTheirBooks ();*/
        printAllBooksByAuthorNameOrderByReleaseDate ("George","Powell");
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate (String firstName,String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate (firstName,lastName)
                .forEach (System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks () {
        authorService
                .getAllAuthorOrderedByCountOfTheirBooks ()
                .forEach (System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBefore1990 (int year) {
        bookService.printAllAuthorsNamesWithBooksWithReleaseDateYear (year)
                .forEach (System.out::println);
    }

    private void printAllBooksAfter2000 (int year) {
        bookService.findAllBooksAfterYear (2000)
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
