package com.lmsbackend.dao;

import com.lmsbackend.entity.BookReview;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookReviewDAOImpl implements BookReviewDAO {

    private EntityManager entityManager;

    @Override
    public List<BookReview> getAllReviewByBookId(int bookId) {
        TypedQuery<BookReview> query = entityManager.createQuery("SELECT br FROM BookReview br WHERE br.book.id = :bookId", BookReview.class);
        query.setParameter("bookId", bookId);
        List<BookReview> bookReviewList = query.getResultList();
        return bookReviewList;
    }

    @Autowired
    public BookReviewDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveBookReview(BookReview bookReview) {
        entityManager.persist(bookReview);
    }

    @Override
    public BookReview findByBookReviewId(Integer bookReviewId) {
        return entityManager.find(BookReview.class, bookReviewId);
    }

    @Override
    public List<BookReview> findAllBookReview() {
        //create query
        TypedQuery<BookReview> query = entityManager.createQuery("from BookReview", BookReview.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateBookReview(BookReview bookReview) {
        entityManager.merge(bookReview);
    }

    @Override
    @Transactional
    public void deleteBookReview(Integer bookReviewId) {
        //retrieve book review
        BookReview bookReview = entityManager.find(BookReview.class, bookReviewId);
        //delete book review
        entityManager.remove(bookReview);
    }

    @Override
    @Transactional
    public int deleteAllBookReviews() {
        int numRowsDeleted = entityManager.createQuery("delete from BookReview").executeUpdate();
        return numRowsDeleted;
    }


}
