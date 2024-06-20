package com.lmsbackend.controller;

import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dto.BookDTO;
import com.lmsbackend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setBookImg(bookDTO.getBookImg());
        book.setStock(bookDTO.getStock());
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

    @PostMapping("/update-book/{id}")
    @Transactional
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book book) {
        bookDAO.updateBook(book);
        return ResponseEntity.ok("Updated Successfully! ");
    }

    @GetMapping("/delete-book/{id}")
    @Transactional
    public String deleteBook(@PathVariable int id) {
        bookDAO.deleteBook(id);
        return "Deleted Successfully ! "+id;
    }
}
