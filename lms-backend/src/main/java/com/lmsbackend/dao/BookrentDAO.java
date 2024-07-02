package com.lmsbackend.dao;

import com.lmsbackend.entity.Bookrent;

import java.util.List;

public interface BookrentDAO {
    public Bookrent save(Bookrent book);

    List<Bookrent> getAllBookRent();
    List<Bookrent> getBookRentUserById(int id);

    public Bookrent getBookrent(int id);

    public void updateBookrent(Bookrent book);

    public void deleteBookrent(int id);
}
