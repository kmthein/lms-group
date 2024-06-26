package com.lmsbackend.dto;

import com.lmsbackend.entity.User;

public class ResponseDTO {
    private String message;
    private User user;
    private String token;

    public ResponseDTO() {
    }
    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public ResponseDTO(String message, User user, String token) {
        this.message = message;
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
