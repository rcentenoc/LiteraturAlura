package com.literaturalura.literaturalura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaturalura.literaturalura.model.Author;
import com.literaturalura.literaturalura.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    public Author getAuthorByName(String name) {
        return authorRepository.searchAuthorByName(name).get();
    }

    public List<Author> getAuthorAlive(int yearAlive) {
        return authorRepository.searchAuthorByYear(yearAlive);
    }
}
