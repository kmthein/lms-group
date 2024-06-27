package com.lmsbackend.dao;

import com.lmsbackend.dto.DashboardCountDTO;
import com.lmsbackend.entity.Author;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Genre;
import com.lmsbackend.entity.Publisher;
import com.lmsbackend.exception.ResourceNotFoundException;
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
    public DashboardCountDTO getAllCount() {
        TypedQuery<DashboardCountDTO> jpql = entityManager.createQuery("SELECT new com.lmsbackend.dto.DashboardCountDTO(" +
                " (SELECT COUNT(b) FROM Book b), " +
                " (SELECT COUNT(g) FROM Genre g), " +
                " (SELECT COUNT(a) FROM Author a), " +
                " (SELECT COUNT(br) FROM Bookrent br))", DashboardCountDTO.class);
        System.out.println(jpql.getSingleResult());
        return jpql.getSingleResult();
    }

    @Override
    @Transactional
    public void saveBook(Book book, int authorId, int publisherId, List<Integer> genreIds) {
        Author author = entityManager.find(Author.class, authorId);
        if (author == null) {
            throw new ResourceNotFoundException("Author id "+ authorId +" is not existed.");
        }
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        if (publisher == null) {
            throw new ResourceNotFoundException("Publisher id "+ publisherId +" is not existed.");
        }
        List<Genre> genres = entityManager.createQuery("SELECT g FROM Genre g WHERE g.genreId IN :ids", Genre.class).setParameter("ids", genreIds).getResultList();
        if (genres.size() != genreIds.size()) {
            throw new ResourceNotFoundException("Genre id not existed.");
        }
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setGenres(genres);
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
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b where b.title = :lastName", Book.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateBook(Book book, int authorId, int publisherId, List<Integer> genreIds) {
        Author author = entityManager.find(Author.class, authorId);
        if (author == null) {
            throw new ResourceNotFoundException("Author id "+ authorId +" is not existed.");
        }
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        if (publisher == null) {
            throw new ResourceNotFoundException("Publisher id "+ publisherId +" is not existed.");
        }
        List<Genre> genres = entityManager.createQuery("SELECT g FROM Genre g WHERE g.genreId IN :ids", Genre.class).setParameter("ids", genreIds).getResultList();
        if (genres.size() != genreIds.size()) {
            throw new ResourceNotFoundException("Genre id not existed.");
        }
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setGenres(genres);
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
