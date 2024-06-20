package com.lmsbackend.dto;

public class GenreBookCountDTO {
    private String genre;
    private int bookCount;

    public GenreBookCountDTO(String genre, int bookCount) {
        this.genre = genre;
        this.bookCount = bookCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
}
