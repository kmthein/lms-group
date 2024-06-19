package com.lmsbackend.dao;

import com.lmsbackend.entity.Librarian;
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
}
