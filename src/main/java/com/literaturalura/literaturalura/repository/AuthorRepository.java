package com.literaturalura.literaturalura.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import com.literaturalura.literaturalura.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Book b JOIN b.author a WHERE a.name LIKE %:name%")
    Optional<Author> searchAuthorByName(@Param("name") String name);

    @Query("SELECT a FROM Author a WHERE a.birth_year <= :year AND a.death_year >= :year")
    List<Author> searchAuthorByYear(@Param("year") int year);
}
