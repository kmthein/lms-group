package com.lmsbackend.dao;

import com.lmsbackend.dto.DashboardCountDTO;
import com.lmsbackend.entity.Book;

import java.util.List;

public interface BookDAO {
    public void saveBook(Book book, int authorId, int publisherId, List<Integer> genreId);

    Book findBookById(int id);

    List<Book> findAllBooks();

    List<Book> findBookByLastName(String lastName);

    void updateBook(Book book, int authorId, int publisherId, List<Integer> genreIds);

    void deleteBook(Integer id);

    int deleteAllBooks();

    DashboardCountDTO getAllCount();
}
