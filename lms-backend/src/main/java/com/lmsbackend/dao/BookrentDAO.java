package com.lmsbackend.dao;

import com.lmsbackend.dto.ShowDataDTO;
import com.lmsbackend.entity.Bookrent;

import java.util.List;

public interface BookrentDAO {
    public Bookrent save(Bookrent book);

    List<Bookrent> getAllBookRent();

    public Bookrent getBookrent(int id);

    public void updateBookrent(Bookrent book);

    public void deleteBookrent(int id);
}
