package com.lmsbackend.dto;

import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Member;

import java.time.LocalDate;

public class RentDTO {
    private LocalDate dueDate;
    private int memberId;
    private int bookId;

    public RentDTO(){}

    public RentDTO(LocalDate dueDate, int memberId, int bookId) {
        this.dueDate = dueDate;
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
}
