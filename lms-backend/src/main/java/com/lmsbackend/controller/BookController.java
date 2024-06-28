package com.lmsbackend.controller;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dto.BookDTO;
import com.lmsbackend.dto.DashboardCountDTO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "http://localhost:5173/")
public class BookController {
    private BookDAO bookDAO;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    private static final String UPLOAD_DIR = System.getProperty("user.home") + "/lms/static/external-images";


    @PostMapping("/create")
    @Transactional
    public ResponseEntity<String> createBook(@ModelAttribute BookDTO bookDTO, @RequestParam(value = "files", required = false) MultipartFile[] files) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setStock(bookDTO.getStock());
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                        Files.createDirectories(Paths.get(UPLOAD_DIR));
                        file.transferTo(new File(UPLOAD_DIR + "/" + fileName));
                        book.setBookImg("/external-images/" + fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
                    }
                } else {
                    System.out.println("Empty file received: " + file.getName());
                }
            }
        } else {
            book.setBookImg("");
        }
        bookDAO.saveBook(book, bookDTO.getAuthorId(), bookDTO.getPublisherId(), bookDTO.getGenreIds());
        return ResponseEntity.ok("Book inserted successfully!");
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookDAO.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookDAO.findBookById(id);
    }

    @PostMapping("/update")
    @Transactional
    public ResponseEntity<String> updateBook(@ModelAttribute BookDTO bookDTO, @RequestParam(value = "files", required = false) MultipartFile[] files, @RequestParam(value = "id") int id) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(bookDTO.getTitle());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setStock(bookDTO.getStock());
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                        Files.createDirectories(Paths.get(UPLOAD_DIR));
                        file.transferTo(new File(UPLOAD_DIR + "/" + fileName));
                        book.setBookImg("/external-images/" + fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
                    }
                } else {
                    System.out.println("Empty file received: " + file.getName());
                }
            }
        } else {
            book.setBookImg(bookDTO.getBookImg());
        }
        System.out.println(id);
        System.out.println(bookDTO.getBookImg());
        System.out.println(bookDTO.getTitle());
        bookDAO.updateBook(book, bookDTO.getAuthorId(), bookDTO.getPublisherId(), bookDTO.getGenreIds());
        return ResponseEntity.ok("Updated Successfully! ");
    }

    @GetMapping("/delete/{id}")
    @Transactional
    public String deleteBook(@PathVariable int id) {
        bookDAO.deleteBook(id);
        return "Deleted Successfully ! "+id;
    }
}
