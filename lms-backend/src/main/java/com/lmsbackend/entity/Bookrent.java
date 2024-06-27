package com.lmsbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_rent")
public class Bookrent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private int rentId;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "status")
    private String status;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "member_id")
    private User member;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "librarian_id")
    private User librarian;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
}
