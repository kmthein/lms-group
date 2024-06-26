package com.lmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int id;
    private String email;
    private String username;
    private String name;
    private String phone;
    private String address;
    private String userImg;
    private String memberType;
    private LocalDate memberStartDate;
    private LocalDate memberExpireDate;
}
