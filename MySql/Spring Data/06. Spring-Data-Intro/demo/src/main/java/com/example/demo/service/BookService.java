package com.example.demo.service;

import com.example.demo.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks () throws IOException;

    List<Book> findAllBooksAfterYear (int year);

    List<String> printAllAuthorsNamesWithBooksWithReleaseDateYear (int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate (String firstName,String lastName);

}