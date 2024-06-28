package com.lmsbackend.dao;

import com.lmsbackend.entity.Librarian;
import com.lmsbackend.entity.User;

public interface LibrarianDAO {
    void save(Librarian librarian);

    User getById(int id);
}
