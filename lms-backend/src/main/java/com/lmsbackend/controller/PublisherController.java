package com.lmsbackend.controller;

import com.lmsbackend.dao.PublisherDAO;
import com.lmsbackend.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PublisherController {
    PublisherDAO publisherDAO;

    @Autowired
    public PublisherController(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    @GetMapping("publisher")
    public List<Publisher> getPublisher() {
        return publisherDAO.getPublisher();
    }

    @GetMapping("publisher/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherDAO.getPublisherById(id);
    }

    @PostMapping("publisher")
    public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher) {
        publisherDAO.save(publisher);
        return ResponseEntity.ok("Publisher updated successfully");
    }

    @PutMapping("publisher/{id}")
    public ResponseEntity<String> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        publisherDAO.updatePublisher(publisher);
        return ResponseEntity.ok("Publisher updated successfully");
    }

    @DeleteMapping("publisher/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable int id) {
        publisherDAO.deletePublisher(id);
        return ResponseEntity.ok("Publisher deleted successfully");
    }
}
