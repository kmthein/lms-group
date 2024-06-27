package com.lmsbackend.controller;

import com.lmsbackend.dao.BookrentDAO;
import com.lmsbackend.dto.RentDTO;
import com.lmsbackend.dto.ShowDataDTO;
import com.lmsbackend.entity.Bookrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("api/rent")
public class BookrentController {
    private BookrentDAO bookerentDAO;
    @Autowired
    public BookrentController(BookrentDAO bookerentDAO) {
        this.bookerentDAO = bookerentDAO;
    }

    @GetMapping("all")
    public List<ShowDataDTO> getBookrent() {
        return bookerentDAO.getBookrent();
    }
    @GetMapping("{id}")
    public Bookrent getBookrentById(@PathVariable int id) {
        return bookerentDAO.getBookrent(id);
    }
    @PostMapping("create")
    public ResponseEntity<String> addBookrent(@ModelAttribute RentDTO rent) {
        System.out.println(rent);
//        Bookrent bookrent = new Bookrent();
//        bookrent.setRentDate(LocalDate.now());
//        bookrent.setStatus("pending");
//        bookerentDAO.save(bookrent,rent.getMemberId(),rent.getBookId());
        return ResponseEntity.ok("Bookrent added successfully");
    }

    @PostMapping("update/{id}")
    public ResponseEntity<String> updateBookrent(@PathVariable int id, @RequestBody Bookrent bookrent) {
        bookerentDAO.updateBookrent(bookrent);
        return ResponseEntity.ok("Bookrent updated successfully");
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteBookrent(@PathVariable int id) {
        bookerentDAO.deleteBookrent(id);
        return ResponseEntity.ok("Bookrent deleted successfully");
    }

}
