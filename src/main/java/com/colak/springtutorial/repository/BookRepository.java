package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BookRepository extends R2dbcRepository<Book, Long> {
}
