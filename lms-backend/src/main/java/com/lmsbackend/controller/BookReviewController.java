package com.lmsbackend.controller;

import com.lmsbackend.dao.BookReviewDAO;
import com.lmsbackend.dto.BookReviewDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.BookReview;
import com.lmsbackend.service.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookreview")
@CrossOrigin
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<?> createBookReview(@ModelAttribute BookReviewDTO bookReviewDTO) {
        System.out.println(bookReviewDTO);
        ResponseDTO response = bookReviewService.makeBookReview(bookReviewDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public List<BookReview> getAllBookReview() {
         return null;
    }

    @PutMapping("/{id}")
    @Transactional
    public String updateBookReview(@PathVariable int id, @RequestBody BookReview bookReview) {
        return null;
    }

    @PostMapping("/delete-bookreview/{id}")
    @Transactional
    public String deleteBookReview(@PathVariable int id) {
        return "Delete BookReview Successfully!"+ id;
    }


}
