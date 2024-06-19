package com.lmsbackend.dao;


import com.lmsbackend.entity.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void saveGenre(Genre genre) {
        em.persist(genre);
    }

    @Override
    public Genre findById(int id) {
        return em.find(Genre.class, id);
    }

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> theQuery = em.createQuery("FROM Genre ", Genre.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateGenre(Genre genre) {
        em.merge(genre);
    }

    @Override
    @Transactional
    public void deleteGenre(int id) {
        Genre theGenre = em.find(Genre.class, id);
        em.remove(theGenre);
    }
}
