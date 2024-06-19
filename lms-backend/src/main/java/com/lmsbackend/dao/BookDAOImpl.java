package com.lmsbackend.dao;

import com.lmsbackend.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findBookById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAllBooks() {
       //create query
        TypedQuery<Book>  query = entityManager.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findBookByLastName(String lastName) {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b where b.book_name = :lastName", Book.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    @Transactional
    public void deleteBook(Integer id) {

        // retrieve the book
        Book book = entityManager.find(Book.class, id);

        // delete the book
        entityManager.remove(book);
    }

    @Override
    @Transactional
    public int deleteAllBooks() {
        int numRowDeleted = entityManager.createQuery("delete from Book").executeUpdate();
        return numRowDeleted;
    }
}
