package com.lmsbackend.controller;

import com.lmsbackend.dao.BookReviewDAO;
import com.lmsbackend.entity.BookReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookreview")
public class BookReviewController {
    private BookReviewDAO bookReviewDAO;

    @Autowired
    public BookReviewController(BookReviewDAO bookReviewDAO) {
        this.bookReviewDAO = bookReviewDAO;
    }

    @PostMapping("/create-bookreview")
    @Transactional
    public String createBookReview(@RequestBody BookReview bookReview) {
        bookReviewDAO.saveBookReview(bookReview);
        return  "Insert BookReview Successfully";
    }

    @GetMapping("/all-bookreviews")
    public List<BookReview> getAllBookReview() {
         return bookReviewDAO.findAllBookReview();
    }

    @GetMapping("/bookreviewbyid/{id}")
    @Transactional
    public BookReview getBookReviewById(@PathVariable int id) {
        return bookReviewDAO.findByBookReviewId(id);
    }

    @PostMapping("/update-bookreview/{id}")
    @Transactional
    public String updateBookReview(@PathVariable int id, @RequestBody BookReview bookReview) {
        bookReviewDAO.updateBookReview(bookReview);
        return "Update BookReview Successfully! "+id;
    }

    @PostMapping("/delete-bookreview/{id}")
    @Transactional
    public String deleteBookReview(@PathVariable int id) {
        bookReviewDAO.deleteBookReview(id);
        return "Delete BookReview Successfully!"+ id;
    }


}
