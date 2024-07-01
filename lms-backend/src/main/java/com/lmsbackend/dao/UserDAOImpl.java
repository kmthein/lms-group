package com.lmsbackend.dao;

import com.lmsbackend.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
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

    @Override
    public User findUserByEmail(String email) {
        Query q = em.createQuery("FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email", email);
        try {
            User user = (User) q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            System.out.println("ERROR TRACE: " + e.getMessage());
            return null;
        }
    }

    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }
}
