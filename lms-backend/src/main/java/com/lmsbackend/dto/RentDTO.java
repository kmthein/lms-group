package com.lmsbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Member;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RentDTO {
    private int rentId;
    private int memberId;
    private int bookId;
    private int librarianId;
    private String status;
    private LocalDate rentDate;
    private LocalDate dueDate;

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    private LocalDate returnDate;

    public RentDTO(){}

    public RentDTO(int memberId, int bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public RentDTO(int memberId, int bookId, String status) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.status = status;
    }

    public RentDTO(int rentId, int memberId, int bookId, String status, LocalDate returnDate) {
        this.rentId = rentId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.status = status;
        this.returnDate = returnDate;
    }

    public RentDTO(int memberId, int bookId, String status, LocalDate returnDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.status = status;
        this.returnDate = returnDate;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public RentDTO(int rentId, int memberId, int bookId, int librarianId, String status, LocalDate returnDate) {
        this.rentId = rentId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.librarianId = librarianId;
        this.status = status;
        this.returnDate = returnDate;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
