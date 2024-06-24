package com.lmsbackend.dao;

import com.lmsbackend.entity.Bookrent;

import java.util.List;

public interface BookerentDAO {
    public void save(Bookrent book,int memberId,int bookId);

    public List<Bookrent> getBookrent();

    public Bookrent getBookrent(int id);

    public void updateBookrent(Bookrent book);

    public void deleteBookrent(int id);
}
