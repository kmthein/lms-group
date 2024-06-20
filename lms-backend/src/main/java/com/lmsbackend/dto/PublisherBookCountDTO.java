package com.lmsbackend.dto;

public class PublisherBookCountDTO {
    private String publisherName;
    private long bookCount;

    public PublisherBookCountDTO(String publisherName, long bookCount) {
        this.publisherName = publisherName;
        this.bookCount = bookCount;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }
}
