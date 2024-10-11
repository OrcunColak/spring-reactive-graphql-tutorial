package com.colak.springtutorial.service;

import com.colak.springtutorial.jpa.Book;
import com.colak.springtutorial.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Mono<Book> addBook(Book book) {
        return bookRepository.save(book);
    }

    public Mono<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id)
                .flatMap(book -> {
                    book.setTitle(bookDetails.getTitle());
                    book.setAuthor(bookDetails.getAuthor());
                    book.setPublisher(bookDetails.getPublisher());
                    book.setPrice(bookDetails.getPrice());
                    return bookRepository.save(book); // Returns a Mono<Book>
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Book not found")));
    }

    public Mono<Boolean> deleteBook(Long id) {
        return bookRepository.existsById(id)
                .flatMap(exists -> {
                    if (exists) {
                        return bookRepository.deleteById(id).then(Mono.just(true));
                    } else {
                        return Mono.just(false);
                    }
                });
    }
}
