package com.lmsbackend.service;

import com.lmsbackend.dto.BookReviewDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.BookReview;

import java.util.List;

public interface BookReviewService {
    ResponseDTO makeBookReview(BookReviewDTO bookReviewDTO);

    List<BookReview> getAllReviewsByBook(int id);
}
