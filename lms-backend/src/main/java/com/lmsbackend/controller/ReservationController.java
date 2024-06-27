package com.lmsbackend.controller;

import com.lmsbackend.dao.ReservationDAO;
import com.lmsbackend.dto.RentDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Author;
import com.lmsbackend.entity.Reservation;
import com.lmsbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
@CrossOrigin
public class ReservationController {
    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("all")
    public List<Reservation> getReservation() {
        return reservationDAO.findall();
    }

    @GetMapping("{id}")
    public Reservation getReservation(@PathVariable int id) {
        return reservationDAO.getReservationById(id);
    }
    @PostMapping("create")
    private ResponseDTO addReservation(@ModelAttribute RentDTO reservation){
        ResponseDTO res = reservationService.makeReservation(reservation.getMemberId(), reservation.getBookId());
        return res;
    }
    @PostMapping("update/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        reservationDAO.updateReservation(reservation);
        return ResponseEntity.ok("Updated successful");


    }
    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int id){
        reservationDAO.deleteReservation(id);
        return ResponseEntity.ok("Delete Successful");
    }
}
