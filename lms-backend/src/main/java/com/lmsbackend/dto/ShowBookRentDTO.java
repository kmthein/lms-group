package com.lmsbackend.dto;

import com.lmsbackend.entity.Genre;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ShowBookRentDTO {
    private int rentId;
    private String imgName;
    private String bookTitle;
    private String authorName;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private int publishYear;
    private List<Genre> genres;

    public ShowBookRentDTO(){}

    public ShowBookRentDTO(int rentId, String bookTitle, String authorName,String imgName,LocalDate rentDate,LocalDate dueDate,int publishYear,List<Genre> genres) {
        this.rentId = rentId;
        this.imgName = imgName;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.publishYear = publishYear;
        this.genres = genres;

    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

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

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
