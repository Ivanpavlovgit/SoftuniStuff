package com.example.demo.service.impl;

import com.example.demo.model.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";


    public AuthorServiceImpl (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors () throws IOException {
        if (authorRepository.count () > 0) {
            return;
        }
        Files
                .readAllLines (Path.of (AUTHORS_FILE_PATH))
                .forEach (row -> {
                    String[] fullName = row.split ("\\s+");

                    String firstName = fullName[0];
                    String lastName  = fullName[1];
                    Author author    = new Author (firstName,lastName);
                    authorRepository.save (author);
                });
    }

    @Override
    public Author getRandomAuthor () {

        long randomId = ThreadLocalRandom.current ().nextLong (1,
                authorRepository.count () + 1);

        return authorRepository
                .findById (randomId)
                .orElse (null);
    }

    @Override
    public List<String> getAllAuthorOrderedByCountOfTheirBooks () {

        return authorRepository
                .findAllByBooksSizeDESC ()
                .stream ()
                .map (author ->
                    String.format ("%s %s %d",
                            author.getFirstName (),
                            author.getLastName (),
                            author.getBooks ().size ()))
                .collect(Collectors.toList());
    }
}
