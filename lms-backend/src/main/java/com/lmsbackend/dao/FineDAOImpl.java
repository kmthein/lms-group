package com.lmsbackend.dao;

import com.lmsbackend.dto.FineDTO;
import com.lmsbackend.entity.Fine;
import com.lmsbackend.entity.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
public class FineDAOImpl implements FineDAO {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void saveFine(Fine fine) {
        em.persist(fine);


    }

    @Override
    public Fine getById(int id) {
        return em.find(Fine.class, id);
    }

    @Override
    public List<Fine> findAll() {
        TypedQuery<Fine> theQuery = em.createQuery("FROM Fine ", Fine.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateFine(Fine fine) {
        em.merge(fine);
    }

    @Override
    @Transactional
    public void deleteFine(int id) {
        Fine theFine = em.find(Fine.class, id);
        em.remove(theFine);
    }


}
