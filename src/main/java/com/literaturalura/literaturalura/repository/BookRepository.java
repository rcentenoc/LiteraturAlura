package com.literaturalura.literaturalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.literaturalura.literaturalura.model.Book;
import com.literaturalura.literaturalura.model.Language;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b JOIN b.author a WHERE b.title LIKE %:title%")
    Optional<Book> searchBookByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.language = :language")
    List<Book> searchBookByLanguage(@Param("language") Language language);
}