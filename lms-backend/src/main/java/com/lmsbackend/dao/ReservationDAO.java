package com.lmsbackend.dao;

import com.lmsbackend.entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    void saveReservation(Reservation reservation);
    List<Reservation> findall();
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);



}
