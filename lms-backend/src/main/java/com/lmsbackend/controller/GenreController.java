package com.lmsbackend.controller;


import com.lmsbackend.dao.GenreDAO;

import com.lmsbackend.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/genre")
public class GenreController {

    @Autowired
    private GenreDAO genreDAO;

    @GetMapping("all")
    public List<Genre> getById(){
        return genreDAO.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<String> createGenre(@RequestBody Genre genre) {
        genreDAO.saveGenre(genre);
        return ResponseEntity.ok("Saved Genre");
    }

    @GetMapping("{id}")
    public Genre findById(@PathVariable int id) {
        return genreDAO.findById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateGenre(@RequestBody Genre genre, @PathVariable int id) {
        genreDAO.updateGenre(genre);
        return ResponseEntity.ok("Updated Genre");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable int id) {
        genreDAO.deleteGenre(id);
        return ResponseEntity.ok("Deleted Genre");
    }
}
