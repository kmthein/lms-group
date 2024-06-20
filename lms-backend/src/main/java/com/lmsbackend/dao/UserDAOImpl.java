package com.lmsbackend.dao;

import com.lmsbackend.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = em.createQuery("FROM User", User.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }
}
