package com.lmsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book_review")

public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private int review_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="book_id")
    private int book_id;

    @Column(name="description")
    private String description;

    @Column(name="review_date")
    private LocalDate review_date;

}
