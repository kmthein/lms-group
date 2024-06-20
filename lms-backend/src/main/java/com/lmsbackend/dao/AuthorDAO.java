package com.lmsbackend.dao;

import com.lmsbackend.entity.Author;

import java.util.List;

public interface AuthorDAO {
    void saveAuthor (Author author);
    Author getAuthor (int id);
    List<Author>findall();
    void updateAuthor(Author author);
    void deleteAuthor(int id);
}
