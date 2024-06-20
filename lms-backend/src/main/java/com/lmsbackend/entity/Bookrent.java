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

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "librarian_id")
    private int librarianId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "librarian_id")
    Librarian librarian;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
}
