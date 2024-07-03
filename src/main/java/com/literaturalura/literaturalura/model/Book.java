package com.literaturalura.literaturalura.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title")
    private String titleOfBook;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    @Column(name = "download_count")
    private Double downloadCount;

    @Column(name = "subjects")
    private List<String> subjects;

    @Column(name = "bookshelves")
    private List<String> bookshelves;

    public Book() {
    }

    public Book(RBooks books) {
        this.titleOfBook = books.titleOfBook();
        this.author = new Author(books.author().get(0));
        this.language = Language.valueOf(books.language().get(0));
        this.downloadCount = books.downloadCount();
        this.subjects = books.subjects();
        this.bookshelves = books.bookshelves();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Double getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Double downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

}
