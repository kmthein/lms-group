package com.lmsbackend.dao;

import com.lmsbackend.entity.Librarian;
import com.lmsbackend.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO {

    @Autowired
    private EntityManager em;

    @Override
    public void save(Librarian librarian) {
        em.persist(librarian);
    }

    @Override
    public User getById(int id) {
        User librarian = em.find(User.class, id);
        return librarian;
    }
}
