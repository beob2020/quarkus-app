package com.app.books;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;


@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class BookResource {
    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> getAllBooks() {
        log.info("Returns all Books");
        List<Book> allBooks = bookRepository.getAllBooks();
        if (allBooks.isEmpty()){
            throw new EmptyStackException();
        }
        return allBooks;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        log.info("Counts number of Books");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        log.info("Returns a single book with id" + id);
        return bookRepository.getBook(id);
    }
}
