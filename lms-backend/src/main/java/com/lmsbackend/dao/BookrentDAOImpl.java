package com.lmsbackend.dao;

import com.lmsbackend.dto.ShowBookRentDTO;
import com.lmsbackend.entity.Bookrent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookrentDAOImpl implements BookrentDAO {
    private EntityManager em;

    @Autowired
    public BookrentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public Bookrent save(Bookrent bookrent) {
        em.persist(bookrent);
        return bookrent;
    }

    @Override
    public List<Bookrent> getAllBookRent() {
        TypedQuery<Bookrent> query = em.createQuery("from Bookrent ",Bookrent.class);
        return query.getResultList();
    }

    @Override
    public List<Bookrent> getBookRentUserById(int id) {
        TypedQuery<Bookrent> query = em.createQuery("from Bookrent br where br.member.id=:id",Bookrent.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public Bookrent getBookrent(int id) {
        return em.find(Bookrent.class, id);
    }

    @Override
    @Transactional
    public void updateBookrent(Bookrent book) {
        em.merge(book);
    }

    @Override
    public void deleteBookrent(int id) {
        em.remove(getBookrent(id));
    }

}
