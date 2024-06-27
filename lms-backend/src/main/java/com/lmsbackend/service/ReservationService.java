package com.lmsbackend.service;

import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Reservation;

public interface ReservationService {
    ResponseDTO makeReservation(int memberId, int bookId);
}
