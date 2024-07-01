package com.lmsbackend.service;

import com.lmsbackend.entity.Reservation;

public interface ReservationService {
    void addReservation(int memberId, int bookId);
}
