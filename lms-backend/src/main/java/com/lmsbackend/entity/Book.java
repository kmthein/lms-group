package com.lmsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int book_id;

    @Column(name="title")
    private String book_name;

    @Column(name="publish_year")
    private int publish_year;

    @Column(name="book_img")
    private String book_img;

    @Column(name="stock")
    private int stock;

    @Column(name="author_id")
    private int author_id;

    @Column(name="publisher_id")
    private int publisher_id;
}
