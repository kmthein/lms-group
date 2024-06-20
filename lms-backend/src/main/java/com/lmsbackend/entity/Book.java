package com.lmsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="publish_year")
    private int publishYear;

    @Column(name="book_img")
    private String bookImg;

    @Column(name="stock")
    private int stock;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @JsonIgnoreProperties("books")
    private List<Genre> genres;
}
