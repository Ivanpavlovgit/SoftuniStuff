package com.example.demo.service.impl;

import com.example.demo.model.entity.Book;
import com.example.demo.model.entity.enums.AgeRestriction;
import com.example.demo.model.entity.enums.EditionType;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl (BookRepository bookRepository,AuthorService authorService,CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks () throws IOException {
        if (bookRepository.count () > 0) {
            return;
        }
        Files.readAllLines (Path.of (BOOKS_FILE_PATH))
                .forEach (row -> {
                    String[] bookInfo = row.split ("\\s+");

                    var book = createBookFromInfo (bookInfo);

                    bookRepository.save (book);
                });

    }

    @Override
    public List<Book> findAllBooksAfterYear (int year) {


        return bookRepository
                .findAllByReleaseDateAfter (LocalDate
                        .of (year,12,1));
    }

    @Override
    public List<String> printAllAuthorsNamesWithBooksWithReleaseDateYear (int year) {
        return bookRepository
                .findAllByReleaseDateBefore (LocalDate.of (year,1,1))
                .stream ()
                .map (book -> String.format ("%s %s",book.getAuthor ().getFirstName (),book.getAuthor ().getLastName ()))
                .distinct ()
                .collect (Collectors.toList ());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate (String firstName,String lastName) {


       return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle (firstName,lastName)
                .stream ()
                .map (book -> String.format ("%s %s %d",
                        book.getTitle (),
                        book.getReleaseDate (),
                        book.getCopies ()))
                .collect (Collectors.toList ());
    }

    private Book createBookFromInfo (String[] bookInfo) {
        var editionType = EditionType.values ()[Integer.parseInt (bookInfo[0])];
        var releaseDate = LocalDate
                .parse (bookInfo[1],DateTimeFormatter.ofPattern ("d/M/yyyy"));
        var copies         = Integer.parseInt (bookInfo[2]);
        var price          = new BigDecimal (bookInfo[3]);
        var ageRestriction = AgeRestriction.values ()[Integer.parseInt (bookInfo[4])];
        var title = Arrays.stream (bookInfo)
                .skip (5)
                .collect (Collectors.joining (" "));
        var author     = authorService.getRandomAuthor ();
        var categories = categoryService.getRandomCategory ();

        return new Book ()
                .setEditionType (editionType)
                .setReleaseDate (releaseDate)
                .setCopies (copies)
                .setPrice (price)
                .setAgeRestriction (ageRestriction)
                .setTitle (title)
                .setAuthor (author)
                .setCategories (categories);
    }
}

