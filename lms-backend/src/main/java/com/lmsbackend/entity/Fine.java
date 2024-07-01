package com.lmsbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fine")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fine_id")
    private int fineId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "fine_date")
    private LocalDate fineDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "rent_id")
    Bookrent bookrent;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;

}
