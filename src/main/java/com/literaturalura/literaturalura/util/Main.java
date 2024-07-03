package com.literaturalura.literaturalura.util;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.literaturalura.literaturalura.model.Book;
import com.literaturalura.literaturalura.service.AuthorService;
import com.literaturalura.literaturalura.service.BookService;
import com.literaturalura.literaturalura.service.ConnectionApi;
import com.literaturalura.literaturalura.service.ConvertData;

@Component
public class Main {
    private ConnectionApi connect = new ConnectionApi();
    private ConvertData convert = new ConvertData();
    private final String URL = "https://gutendex.com/books/?search=";

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public void mainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Search book by title");
                System.out.println("2. Search book by language");
                System.out.println("3. Search author by name");
                System.out.println("4. Search author by year alive");
                System.out.println("5. Exit");
                System.out.print("Choose: ");
                int choice = Integer.parseInt(scanner.nextLine());
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        searchBookByTitle(scanner);
                        break;
                    case 2:
                        searchBookByLanguage(scanner);
                        break;
                    case 3:
                        searchAuthorByName(scanner);
                        break;
                    case 4:
                        searchAuthorByYear(scanner);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchBookByTitle(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        var booksUrl = connect.getData(URL + title);
        var booksTemp = convert.convertData(booksUrl, Book.class);
        Optional<Book> book = Optional.of(booksTemp);
        bookService.saveBook(book.get());
        System.out.println("Book found: " + book.get());
    }

    private void searchBookByLanguage(Scanner scanner) {
        System.out.print("Enter language: ");
        String lang = scanner.nextLine();
        var booksUrl = connect.getData(URL + lang);
        var booksTemp = convert.convertData(booksUrl, Book.class);

        Optional<Book> book = Optional.of(booksTemp);
        bookService.saveBook(book.get());
        System.out.println("Book found: " + book.get());
    }

    private void searchAuthorByName(Scanner scanner) {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();
        authorService.getAuthorByName(name);
    }

    private void searchAuthorByYear(Scanner scanner) {
        System.out.print("Enter year alive: ");
        int yearAlive = Integer.parseInt(scanner.nextLine());
        authorService.getAuthorAlive(yearAlive);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.mainMenu();
    }
}
