package com.lmsbackend.controller;

import com.lmsbackend.dao.ReservationDAO;
import com.lmsbackend.entity.Author;
import com.lmsbackend.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReservationController {
    @Autowired
    private ReservationDAO reservationDAO;

    @GetMapping("/reservation")
    public List<Reservation> getReservation() {
        return reservationDAO.findall();
    }

    @PostMapping("/creatreservation")
    private ResponseEntity<String> addReservation(@RequestBody Reservation reservation){
        reservationDAO.saveReservation(reservation);
        return ResponseEntity.ok("Added successful");
    }
    @PostMapping("updatreservation/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        reservationDAO.updateReservation(reservation);
        return ResponseEntity.ok("Updated successful");


    }
    @GetMapping("deletereservation/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int id){
        reservationDAO.deleteReservation(id);
        return ResponseEntity.ok("Delete Successful");
    }
}
