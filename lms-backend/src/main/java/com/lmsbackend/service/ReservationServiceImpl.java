package com.lmsbackend.service;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dao.ReservationDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Reservation;
import com.lmsbackend.entity.User;
import com.lmsbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService {
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private ReservationDAO reservationDAO;


    public ReservationServiceImpl(UserDAO userDAO, BookDAO bookDAO, ReservationDAO reservationDAO) {
        this.userDAO = userDAO;
        this.bookDAO = bookDAO;
        this.reservationDAO = reservationDAO;

    }

    @Override
    public void addReservation(int memberId, int bookId) {
        User user = userDAO.findUserById(memberId);
        Book book = bookDAO.findBookById(bookId);

        if (user == null){
            throw new ResourceNotFoundException("User not found");
        }
        if (book == null){
            throw new ResourceNotFoundException("Book not found");
        }

        Reservation reservation = new Reservation();
        reservation.setMember(user);
        reservation.setBook(book);
        LocalDate currentDate = LocalDate.now();
        reservation.setDate(currentDate);
        reservation.setStatus("Pending");
        reservationDAO.saveReservation(reservation);
    }

}
