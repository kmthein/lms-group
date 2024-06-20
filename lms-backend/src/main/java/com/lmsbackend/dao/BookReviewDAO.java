package com.lmsbackend.dao;

import com.lmsbackend.entity.BookReview;

import java.util.List;

public interface BookReviewDAO {

    //save data
    void saveBookReview(BookReview bookReview);

    //read data
    BookReview findByBookReviewId(Integer bookReviewId);

    //display all save data
    List<BookReview> findAllBookReview();

    //update
    void updateBookReview(BookReview bookReview);

    //delete by id
    void deleteBookReview(Integer bookReviewId);

    //delete all
    int deleteAllBookReviews();

}
