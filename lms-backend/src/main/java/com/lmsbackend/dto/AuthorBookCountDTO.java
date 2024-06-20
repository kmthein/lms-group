package com.lmsbackend.dto;

import com.lmsbackend.entity.Author;

public class AuthorBookCountDTO {
    private int key;
    private String name;
    private String image;
    private long bookCount;

    public AuthorBookCountDTO(String name, long bookCount) {
        this.name = name;
        this.bookCount = bookCount;
    }

    public AuthorBookCountDTO(int key, String name, String image, long bookCount) {
        this.key = key;
        this.name = name;
        this.image = image;
        this.bookCount = bookCount;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }
}
