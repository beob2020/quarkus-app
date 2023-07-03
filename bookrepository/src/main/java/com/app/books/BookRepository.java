package com.app.books;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    @ConfigProperty(name = "books.genre", defaultValue = "Programming")
    String genre;
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Java made simple", "Benard", genre, Year.of(2021)),
                new Book(2, "Understanding Java", "Benard", genre, Year.of(2000)),
                new Book(3, "This is Java", "Benard", genre, Year.of(2022)),
                new Book(4, "Learn Java", "Benard", genre, Year.of(2023)));
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
    }
}
