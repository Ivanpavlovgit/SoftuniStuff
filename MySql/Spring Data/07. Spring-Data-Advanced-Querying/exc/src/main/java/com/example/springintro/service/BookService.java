package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTitlesWithAgeRestriction (AgeRestriction ageRestriction);

    List<String> findAllGoldBookTitlesWithLessThan5000 ();

    List<String> findAllBookTitlesAndPricesNotBetween5And40 ();

    List<String> findAllBookTitlesNotReleasedInTheGivenYear (int year);

    List<String> findAllBooksWithReleaseDateAfterDate (LocalDate date);

    List<String> findAllBooksWithTitlesIncluding (String str);

    List<String> findAllBooksWithAuthorWithLastNameStartingWith (String str);

    int findCountOfBooksWithTitlesLongerThan (int length);

    String getReducedInformationAboutBookByTitle (String bookTitle);
}
