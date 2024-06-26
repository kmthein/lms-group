package com.lmsbackend.dto;

import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Librarian;


import java.time.LocalDate;

public class ShowDataDTO {
    private int rentId;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private String status;
    private LocalDate returnDate;
    private Book book;

    public ShowDataDTO() {}



    public ShowDataDTO(int rentId, LocalDate rentDate, LocalDate dueDate, String status, LocalDate returnDate, Book book) {
        this.rentId = rentId;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.status = status;
        this.returnDate = returnDate;
        this.book = book;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }
}
