package com.lmsbackend.controller;
import com.lmsbackend.dao.AuthorDAO;
import com.lmsbackend.dto.AuthorBookCountDTO;
import com.lmsbackend.dto.PublisherBookCountDTO;
import com.lmsbackend.entity.Author;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/author")
@CrossOrigin
public class AuthorController {
    @Autowired
    private AuthorDAO authorDAO;

    private static final String UPLOAD_DIR = System.getProperty("user.home") + "/lms/static/external-images";

    @GetMapping("/all")
    public List<Author> getAuthor(){
        return authorDAO.findall();
    }

    @GetMapping("/authors-book")
    public List<AuthorBookCountDTO> getAuthorsAndBookCount() {
        return authorDAO.getAuthorAndBookTotal();
    }

    @GetMapping("{id}")
    public Author getAuthorById(@PathVariable int id){
        return authorDAO.getAuthor(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAuthor(@ModelAttribute Author author, @RequestParam("files") MultipartFile[] files) {
        System.out.println("Received request to add author");
        System.out.println("Author: " + author.getName());
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                    Files.createDirectories(Paths.get(UPLOAD_DIR));
                    file.transferTo(new File(UPLOAD_DIR + "/" + fileName));
                    author.setAuthorImg("/external-images/" + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
                }
            } else {
                System.out.println("Empty file received: " + file.getName());
            }
        }
        authorDAO.saveAuthor(author);
        return ResponseEntity.ok("Added successfully");
    }


    @PostMapping("update/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable int id, @RequestBody Author author){
        authorDAO.updateAuthor(author);
        return ResponseEntity.ok("Updated successful");


    }
    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id){
        authorDAO.deleteAuthor(id);
        return ResponseEntity.ok("Delete Successful");
    }



}
