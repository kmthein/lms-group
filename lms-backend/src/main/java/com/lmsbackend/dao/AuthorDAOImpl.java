package com.lmsbackend.dao;
import com.lmsbackend.dto.AuthorBookCountDTO;
import com.lmsbackend.dto.PublisherBookCountDTO;
import com.lmsbackend.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
    @Autowired

    private EntityManager em;

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        em.persist(author);
    }

    @Override
    public Author getAuthor(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public List<Author> findall() {
        TypedQuery<Author> query = em.createQuery("From Author",Author.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
            em.merge(author);

    }

    @Override
    @Transactional
    public void deleteAuthor(int id) {
            Author author = em.find(Author.class,id);
            em.remove(author);
    }
    @Override
    public List<AuthorBookCountDTO> getAuthorAndBookTotal() {
        String jpql = "SELECT new com.lmsbackend.dto.AuthorBookCountDTO(a.id, a.name, a.authorImg, COUNT(b.id)) " +
                "FROM Author a LEFT JOIN Book b ON a.id = b.author.id GROUP BY a.id, a.name";
        TypedQuery<AuthorBookCountDTO> query = em.createQuery(jpql, AuthorBookCountDTO.class);
        return query.getResultList();
    }
}
