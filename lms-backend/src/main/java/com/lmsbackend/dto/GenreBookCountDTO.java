package com.lmsbackend.dto;

public class GenreBookCountDTO {
    private String genre;
    private Long bookCount;

    public GenreBookCountDTO(String genre, Long bookCount) {
        this.genre = genre;
        this.bookCount = bookCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }
}
