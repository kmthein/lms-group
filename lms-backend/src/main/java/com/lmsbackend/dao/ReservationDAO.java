package com.lmsbackend.dao;

import com.lmsbackend.entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    Reservation saveReservation(Reservation reservation);
    Reservation getReservationById(int id);
    Reservation getReservation(int id);
    List<Reservation> findall();
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);



}
