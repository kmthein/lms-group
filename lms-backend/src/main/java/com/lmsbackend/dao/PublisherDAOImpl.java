package com.lmsbackend.dao;

import com.lmsbackend.dto.PublisherBookCountDTO;
import com.lmsbackend.entity.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PublisherDAOImpl implements PublisherDAO {

    private EntityManager em;

    @Autowired
    public PublisherDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Publisher> getPublisher() {
        TypedQuery<Publisher> query = em.createQuery("from Publisher", Publisher.class);
        return query.getResultList();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return em.find(Publisher.class, id);
    }

    @Override
    @Transactional
    public void save(Publisher publisher) {
        em.persist(publisher);

    }

    @Override
    @Transactional
    public void updatePublisher(Publisher publisher) {
        em.merge(publisher);

    }

    @Override
    @Transactional
    public void deletePublisher(int id) {
        em.remove(getPublisherById(id));

    }

    @Override
    public List<PublisherBookCountDTO> getPublisherAndBookTotal() {
        String jpql = "SELECT new com.lmsbackend.dto.PublisherBookCountDTO(p.publisherName, COUNT(b)) " +
                "FROM Book b JOIN b.publisher p " +
                "GROUP BY p.publisherName";
        TypedQuery<PublisherBookCountDTO> query = em.createQuery(jpql, PublisherBookCountDTO.class);
        return query.getResultList();
    }

}
