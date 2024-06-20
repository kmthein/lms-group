package com.lmsbackend.controller;

import com.lmsbackend.dao.PublisherDAO;
import com.lmsbackend.dto.PublisherBookCountDTO;
import com.lmsbackend.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/publisher")
public class PublisherController {
    PublisherDAO publisherDAO;

    @Autowired
    public PublisherController(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    @GetMapping("all")
    public List<Publisher> getPublisher() {
        return publisherDAO.getPublisher();
    }

    @GetMapping("{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherDAO.getPublisherById(id);
    }

    @PostMapping("create")
    public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher) {
        publisherDAO.save(publisher);
        return ResponseEntity.ok("Publisher updated successfully");
    }

    @PostMapping("update/{id}")
    public ResponseEntity<String> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        publisherDAO.updatePublisher(publisher);
        return ResponseEntity.ok("Publisher updated successfully");
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable int id) {
        publisherDAO.deletePublisher(id);
        return ResponseEntity.ok("Publisher deleted successfully");
    }

    @GetMapping("publishersandbooks")
    public List<PublisherBookCountDTO> getPublishersandBooks() {
        return publisherDAO.getPublisherAndBookTotal();
    }
}
