package com.lmsbackend.service;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dao.BookrentDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Bookrent;
import com.lmsbackend.entity.User;
import com.lmsbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookrentServiceImpl implements BookrentService {
    @Autowired
    private BookrentDAO bookrentDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Bookrent> getAllBookrents() {
        return bookrentDAO.getAllBookRent();
    }

    @Override
    public ResponseDTO makeBookrent(int memberId, int bookId) {
        User user = userDAO.findUserById(memberId);
        Book book = bookDAO.findBookById(bookId);
        if (user == null) {
            throw new ResourceNotFoundException("User Not Found");
        }
        if (book == null) {
            throw new ResourceNotFoundException("Book Not Found");
        }
        Bookrent bookrent = new Bookrent();
        bookrent.setBook(book);
        bookrent.setMember(user);
        bookrent.setStatus("Pending");
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(7);
        bookrent.setRentDate(currentDate);
        bookrent.setDueDate(dueDate);
        Bookrent res = bookrentDAO.save(bookrent);
        ResponseDTO responseDTO = new ResponseDTO();
        if (res ==  null) {
            responseDTO.setMessage("Something Went Wrong");
            return responseDTO;
        }
        responseDTO.setMessage("Book Rent Successfully");
        responseDTO.setStatus("201");
        return responseDTO;
    }
}
