package com.lmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianDTO {
    private int id;
    private String email;
    private String username;
    private String name;
    private String phone;
    private String address;
    private String userImg;
    private String role;
    private LocalDate employmentDate;
}
