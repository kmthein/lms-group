package com.lmsbackend.service;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dao.ReservationDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Reservation;
import com.lmsbackend.entity.User;
import com.lmsbackend.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookDAO bookDAO;
    @Override
    public ResponseDTO makeReservation(int memberId, int bookId) {
        User user = userDAO.findUserById(memberId);
        if (user == null) {
            throw new ResourceNotFoundException("User not found.");
        }
        Book book = bookDAO.findBookById(bookId);
        if (book == null) {
            throw new ResourceNotFoundException("Book not found.");
        }
        Reservation reservation = new Reservation();
        reservation.setMember(user);
        reservation.setBook(book);
        reservation.setStatus("active");
        LocalDate currentDate = LocalDate.now();
        reservation.setDate(currentDate);
        Reservation res = reservationDAO.saveReservation(reservation);
        ResponseDTO responseDTO = new ResponseDTO();
        if (res == null) {
            responseDTO.setMessage("Book reservation failed");
            responseDTO.setStatus("403");
            return responseDTO;
        }
        responseDTO.setMessage("Book reservation successful");
        responseDTO.setStatus("201");
        return responseDTO;
    }
}
