package com.literaturalura.literaturalura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaturalura.literaturalura.model.Book;
import com.literaturalura.literaturalura.model.Language;
import com.literaturalura.literaturalura.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookR;

    public void saveBook(Book book) {
        bookR.save(book);
    }

    public List<Book> getAllBooks() {
        return bookR.findAll();
    }

    public Book getBookById(Long id) {
        return bookR.findById(id).get();
    }

    public Book getBookByTitle(String title) {
        return bookR.searchBookByTitle(title).get();
    }

    public List<Book> getBookByLanguage(String lang) {
        try {
            Language language = Language.valueOf(lang);
            return bookR.searchBookByLanguage(language);
        } catch (Exception e) {
            return null;
        }
    }

}
