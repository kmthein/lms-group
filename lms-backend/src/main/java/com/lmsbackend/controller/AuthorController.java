package com.lmsbackend.controller;
import com.lmsbackend.dao.AuthorDAO;
import com.lmsbackend.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private AuthorDAO authorDAO;

    @GetMapping("/author")
    public List<Author> getAuthor(){
        return authorDAO.findall();
    }

    @PostMapping("/createauthor")
    private ResponseEntity<String> addAuthor(@RequestBody Author author){
        authorDAO.saveAuthor(author);
        return ResponseEntity.ok("Added successful");
    }
    @PostMapping("updateauthor/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable int id, @RequestBody Author author){
        authorDAO.updateAuthor(author);
        return ResponseEntity.ok("Updated successful");


    }
    @GetMapping("deleteauthor/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id){
        authorDAO.deleteAuthor(id);
        return ResponseEntity.ok("Delete Successful");
    }

}
