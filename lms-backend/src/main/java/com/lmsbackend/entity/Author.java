package com.lmsbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "author_name")
    private String name;
    @Column(name = "author_img")
    private String authorImg;

    @JsonBackReference
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author(String name, String authorImg) {
        this.name = name;
        this.authorImg = authorImg;
    }

    //    @OneToMany
//    @JoinColumn(name = "author_id")
//    private List<Book> books = new ArrayList<>();
//    @JsonBackReference
//    @OneToMany(mappedBy = "author")
//    private List<Book> books;
}
