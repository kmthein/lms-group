package com.lmsbackend.controller;


import com.lmsbackend.dao.FineDAO;
import com.lmsbackend.entity.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FineController {

    @Autowired
    private FineDAO fineDAO;

    @GetMapping("/fine")
    public List<Fine> getById() {
        return fineDAO.findAll();
    }

    @PostMapping("/fine")
    public ResponseEntity<String> createFine(@RequestBody Fine fine) {
        fineDAO.saveFine(fine);
        return ResponseEntity.ok("Saved Fine");
    }

    @GetMapping("/fine/{id}")
    public Fine findById(@PathVariable int id) {
        return fineDAO.getById(id);
    }

    @PostMapping("/updatefine/{id}")
    public ResponseEntity<String> updateFine(@RequestBody Fine fine,@PathVariable int id) {
        fineDAO.updateFine(fine);
        return ResponseEntity.ok("Updated Fine");
    }

    @PostMapping("/fine/{id}")
    public ResponseEntity<String> deleteFine(@PathVariable int id) {
        fineDAO.deleteFine(id);
        return ResponseEntity.ok("Deleted Fine");
    }


}
