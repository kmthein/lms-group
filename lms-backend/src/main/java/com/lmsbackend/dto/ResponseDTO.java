package com.lmsbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lmsbackend.entity.BookReview;
import com.lmsbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private String message;
    private MemberDTO memberDTO;
    private LibrarianDTO librarianDTO;
    private BookReview bookReview;
    private User user;
    private String token;
    private String status;

    public ResponseDTO(String message, MemberDTO memberDTO, LibrarianDTO librarianDTO, String token, String status) {
        this.message = message;
        this.memberDTO = memberDTO;
        this.librarianDTO = librarianDTO;
        this.token = token;
        this.status = status;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }
}
