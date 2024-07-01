package com.lmsbackend.controller;


import com.lmsbackend.dao.FineDAO;
import com.lmsbackend.dto.FineDTO;
import com.lmsbackend.entity.Fine;
import com.lmsbackend.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/fine")
public class FineController {

    @Autowired
    private FineDAO fineDAO;

    @Autowired
    private FineService fineService;

    @GetMapping("all")
    public List<Fine> getById() {
        return fineDAO.findAll();
    }

//    @PostMapping("create")
//    public ResponseEntity<String> createFine(@RequestBody Fine fine) {
//
//        LocalDate dueDate = null;
//        LocalDate returnDate = LocalDate.of(2012,10,25);
//        fineDAO.saveFine(fine, dueDate, returnDate);
//        return ResponseEntity.ok("Saved Fine");
//    }

    @PostMapping("create")
    public ResponseEntity<String> createFine(@RequestBody FineDTO fineDTO) {
        System.out.println(fineDTO.getDueDate());
        fineService.createFine(fineDTO);
        return null;
    }


    @GetMapping("{id}")
    public Fine findById(@PathVariable int id) {
        return fineDAO.getById(id);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<String> updateFine(@RequestBody Fine fine,@PathVariable int id) {
        fineDAO.updateFine(fine);
        return ResponseEntity.ok("Updated Fine");
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteFine(@PathVariable int id) {
        fineDAO.deleteFine(id);
        return ResponseEntity.ok("Deleted Fine");
    }



}
