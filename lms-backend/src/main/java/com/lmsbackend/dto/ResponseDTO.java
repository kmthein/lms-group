package com.lmsbackend.dto;

import com.lmsbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private MemberDTO memberDTO;
    private User user;
    private String token;
    private String status;

    public ResponseDTO(String message, MemberDTO memberDTO, String token, String status) {
        this.message = message;
        this.memberDTO = memberDTO;
        this.token = token;
        this.status = status;
    }
}
