package com.lmsbackend.controller;

import com.lmsbackend.dao.BookerentDAO;
import com.lmsbackend.entity.Bookrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BookrentController {
    private BookerentDAO bookerentDAO;
    @Autowired
    public BookrentController(BookerentDAO bookerentDAO) {
        this.bookerentDAO = bookerentDAO;
    }

    @GetMapping("bookrent")
    public List<Bookrent> getBookrent() {
        return bookerentDAO.getBookrent();
    }
    @GetMapping("bookrent/{id}")
    public Bookrent getBookrentById(@PathVariable int id) {
        return bookerentDAO.getBookrent(id);
    }
    @PostMapping("bookrent")
    public ResponseEntity<String> addBookrent(@RequestBody Bookrent bookrent) {
        bookerentDAO.save(bookrent);
        return ResponseEntity.ok("Bookrent added successfully");
    }

    @PutMapping("bookrent")
    public ResponseEntity<String> updateBookrent(@RequestBody Bookrent bookrent) {
        bookerentDAO.updateBookrent(bookrent);
        return ResponseEntity.ok("Bookrent updated successfully");
    }

    @DeleteMapping("bookren")
    public ResponseEntity<String> deleteBookrent(@PathVariable int id) {
        bookerentDAO.deleteBookrent(id);
        return ResponseEntity.ok("Bookrent deleted successfully");
    }

}
