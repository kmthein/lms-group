package com.lmsbackend.dao;

import com.lmsbackend.entity.Book;

import java.util.List;

public interface BookDAO {
    //to save book
    public void saveBook(Book book);

    //to read data in Book
    Book findBookById(int id);

    //display list of all data from Book Table
    List<Book> findAllBooks();

    //find by LastName
    List<Book> findBookByLastName(String lastName);

    //update data
    void updateBook(Book book);

    //delete
    void deleteBook(Integer id);

    //delete all
    int deleteAllBooks();
}
