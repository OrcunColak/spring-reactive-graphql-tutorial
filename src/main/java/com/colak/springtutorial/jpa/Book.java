package com.colak.springtutorial.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("BOOKS")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(value = "ID")
    private Long id;

    @Column(value = "TITLE")
    private String title;

    @Column(value = "AUTHOR")
    private String author;

    @Column(value = "PUBLISHER")
    private String publisher;

    @Column(value = "PRICE")
    private Double price;

    public Book(String title, String author, String publisher, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
}
