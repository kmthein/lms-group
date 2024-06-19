package com.lmsbackend.controller;


import com.lmsbackend.dao.GenreDAO;

import com.lmsbackend.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GenreController {

    @Autowired
    private GenreDAO genreDAO;

    @GetMapping("/genre")
    public List<Genre> getById(){
        return genreDAO.findAll();
    }

    @PostMapping("/genre")
    public ResponseEntity<String> createGenre(@RequestBody Genre genre) {
        genreDAO.saveGenre(genre);
        return ResponseEntity.ok("Saved Genre");
    }

    @GetMapping("/genre/{id}")
    public Genre findById(@PathVariable int id) {
        return genreDAO.findById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateGenre(@RequestBody Genre genre, @PathVariable int id) {
        genreDAO.updateGenre(genre);
        return ResponseEntity.ok("Updated Genre");
    }

    @PostMapping("/genre/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable int id) {
        genreDAO.deleteGenre(id);
        return ResponseEntity.ok("Deleted Genre");
    }
}
