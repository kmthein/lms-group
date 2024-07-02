package com.lmsbackend.service;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dao.BookrentDAO;
import com.lmsbackend.dao.LibrarianDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.dto.RentDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.dto.ShowBookRentDTO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Bookrent;
import com.lmsbackend.entity.User;
import com.lmsbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookrentServiceImpl implements BookrentService {
    @Autowired
    private BookrentDAO bookrentDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private LibrarianDAO librarianDAO;

    @Override
    public List<Bookrent> getAllBookrents() {
        return bookrentDAO.getAllBookRent();
    }

    @Override
    public List<ShowBookRentDTO> getBookRents(int id) {
        List<Bookrent> bookrents = bookrentDAO.getBookRentUserById(id);
        List<ShowBookRentDTO> userbookrent = new ArrayList<>();

        for(Bookrent br : bookrents){
            ShowBookRentDTO showBookRentDTO = new ShowBookRentDTO();

            showBookRentDTO.setRentId(br.getRentId());
            showBookRentDTO.setImgName(br.getBook().getBookImg());
            showBookRentDTO.setBookTitle(br.getBook().getTitle());
            showBookRentDTO.setGenres(br.getBook().getGenres());
            showBookRentDTO.setRentDate(br.getRentDate());
            showBookRentDTO.setDueDate(br.getDueDate());
            showBookRentDTO.setPublishYear(br.getBook().getPublishYear());
            showBookRentDTO.setAuthorName(br.getBook().getAuthor().getName());
            userbookrent.add(showBookRentDTO);
        }
        return  userbookrent;

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

    @Override
    @Transactional
    public ResponseDTO updateBookrent(RentDTO rentDTO) {
        Bookrent rent = bookrentDAO.getBookrent(rentDTO.getRentId());
        User member = userDAO.findUserById(rentDTO.getMemberId());
        Book book = bookDAO.findBookById(rentDTO.getBookId());
        User librarian = librarianDAO.getById(rentDTO.getLibrarianId());
        if (rent == null) {
            throw new ResourceNotFoundException("Rent not found.");
        }
        if (member == null) {
            throw new ResourceNotFoundException("Member not found.");
        }
        if (book == null) {
            throw new ResourceNotFoundException("Book not found.");
        }
        Bookrent bookrent = new Bookrent();
        bookrent.setRentId(rent.getRentId());
        bookrent.setMember(member);
        bookrent.setBook(book);
        bookrent.setLibrarian(librarian);
        bookrent.setStatus(rentDTO.getStatus());
        bookrent.setRentDate(rentDTO.getRentDate());
        bookrent.setDueDate(rentDTO.getDueDate());
        bookrent.setReturnDate(rentDTO.getReturnDate());
        bookrentDAO.updateBookrent(bookrent);
        return null;
    }
}
