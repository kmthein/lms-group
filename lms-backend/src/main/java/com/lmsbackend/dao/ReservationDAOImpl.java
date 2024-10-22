package com.lmsbackend.dao;

import com.lmsbackend.entity.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class ReservationDAOImpl implements ReservationDAO{
    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        em.persist(reservation);
        return reservation;
    }

    @Override
    public Reservation getReservationById(int id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public Reservation getReservation(int id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> findall() {
        TypedQuery<Reservation> query = em.createQuery("From Reservation", Reservation.class);
        return query.getResultList();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        em.merge(reservation);

    }

    @Override
    public void deleteReservation(int id) {
        Reservation reservation = em.find(Reservation.class, id);
        em.remove(reservation);

    }
}
