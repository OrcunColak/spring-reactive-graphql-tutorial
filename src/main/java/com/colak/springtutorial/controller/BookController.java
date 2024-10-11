package com.colak.springtutorial.controller;

import com.colak.springtutorial.jpa.Book;
import com.colak.springtutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public Flux<Book> books() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Mono<Book> bookById(@Argument Long id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Mono<Book> addBook(@Argument String title, @Argument String author,
                              @Argument String publisher, @Argument Double price) {
        return bookService.addBook(new Book(title, author, publisher, price));
    }

    @MutationMapping
    public Mono<Book> updateBook(@Argument Long id, @Argument String title,
                                 @Argument String author, @Argument String publisher,
                                 @Argument Double price) {
        Book bookDetails = new Book(title, author, publisher, price);
        return bookService.updateBook(id, bookDetails);
    }

    @MutationMapping
    public Mono<Boolean> deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }
}
