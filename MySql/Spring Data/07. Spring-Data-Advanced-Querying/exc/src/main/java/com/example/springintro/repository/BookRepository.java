package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter (LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore (LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle (String author_firstName,String author_lastName);

    List<Book> findAllByAgeRestriction (AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan (EditionType editionType,Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan (BigDecimal price,BigDecimal price2);

    List<Book> findAllByReleaseDateAfterOrReleaseDateBefore (LocalDate releaseDate,LocalDate releaseDate2);

    List<Book> findAllByTitleContaining (String title);

    List<Book> findAllByAuthor_LastNameStartsWith (String author_lastName);

    @Query("SELECT COUNT (b) FROM Book b WHERE length(b.title)>:param1")
    int countOfBooksWithTitleLengthMoreThan (@Param(value = "param1") int titleLength);

    Book findAllByTitle (String title);


    int countAllByAuthor_FirstNameAndAuthorLastName (String author_firstName,String author_lastName);

    @Query("UPDATE Book b SET b.copies=b.copies+:amount WHERE b.releaseDate=:date")
    @Modifying
    void increaseCopiesOfBookPrintedOnSelectedDateBySelectedAmount (LocalDate date,int amount);



}
