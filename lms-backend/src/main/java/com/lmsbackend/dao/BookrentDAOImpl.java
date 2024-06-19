package com.lmsbackend.dao;

import com.lmsbackend.entity.Bookrent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookrentDAOImpl implements BookerentDAO {
    private EntityManager em;

    @Autowired
    public BookrentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Bookrent book) {
        em.persist(book);
    }

    @Override
    public List<Bookrent> getBookrent() {
        TypedQuery<Bookrent> query = em.createQuery("select b from Bookrent b", Bookrent.class);
        return query.getResultList();
    }

    @Override
    public Bookrent getBookrent(int id) {
        return em.find(Bookrent.class, id);
    }

    @Override
    public void updateBookrent(Bookrent book) {
        em.merge(book);
    }

    @Override
    public void deleteBookrent(int id) {
        em.remove(getBookrent(id));
    }

}
