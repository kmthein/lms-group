package com.lmsbackend.service;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dao.BookReviewDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.dto.BookReviewDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.BookReview;
import com.lmsbackend.entity.User;
import com.lmsbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookReviewServiceImpl implements BookReviewService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BookReviewDAO bookReviewDAO;

    @Override
    @Transactional
    public ResponseDTO makeBookReview(BookReviewDTO bookReviewDTO) {
        User tempUser = userDAO.findUserById(bookReviewDTO.getUserId());
        if (tempUser == null) {
            throw new ResourceNotFoundException("User not found.");
        }
        Book tempBook = bookDAO.findBookById(bookReviewDTO.getBookId());
        if (tempBook == null) {
            throw new ResourceNotFoundException("Book not found.");
        }
        BookReview bookReview = new BookReview();
        bookReview.setBook(tempBook);
        bookReview.setUser(tempUser);
        LocalDate currentDate = LocalDate.now();
        bookReview.setReviewDate(currentDate);
        bookReview.setDescription(bookReviewDTO.getDescription());
        bookReviewDAO.saveBookReview(bookReview);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Your book review added.");
        response.setStatus("201");
        return response;
    }

    @Override
    public List<BookReview> getAllReviewsByBook(int id) {
        List<BookReview> bookReviewList = bookReviewDAO.getAllReviewByBookId(id);
        return bookReviewList;
    }
}
