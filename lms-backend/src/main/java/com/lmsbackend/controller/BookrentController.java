package com.lmsbackend.controller;

import com.lmsbackend.dao.BookrentDAO;
import com.lmsbackend.dto.RentDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.dto.ShowDataDTO;
import com.lmsbackend.entity.Bookrent;
import com.lmsbackend.service.BookrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("api/rent")
public class BookrentController {

    @Autowired
    private BookrentService bookrentService;

    @GetMapping("all")
    public List<Bookrent> getBookrent() {
        return bookrentService.getAllBookrents();
    }
    @GetMapping("{id}")
    public Bookrent getBookrentById(@PathVariable int id) {
        return null;
    }
    @PostMapping("create")
    public ResponseDTO addBookrent(@ModelAttribute RentDTO rent) {
        ResponseDTO responseDTO = bookrentService.makeBookrent(rent.getMemberId(), rent.getBookId());
        return responseDTO;
    }
}
