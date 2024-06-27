package com.lmsbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;
    @Column(name = "reservation_date")
    private LocalDate date;
    @Column(name = "status")
    private String status;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    Book book;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "member_id")
    User member;
}
