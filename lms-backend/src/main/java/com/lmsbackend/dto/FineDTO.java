package com.lmsbackend.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FineDTO {
    private LocalDate dueDate;
    private LocalDate returnDate;
    private int rentId;
    private int memberId;

    public FineDTO() {

    }

    public FineDTO(LocalDate dueDate, LocalDate returnDate, int rentId, int memberId) {
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.rentId = rentId;
        this.memberId = memberId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
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
}
