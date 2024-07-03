package com.lmsbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookReviewDTO {
    private int userId;
    private int bookId;
    private String description;
}
