package com.lmsbackend.dao;

import com.lmsbackend.dto.ShowDataDTO;
import com.lmsbackend.entity.Book;
import com.lmsbackend.entity.Bookrent;
import com.lmsbackend.entity.Member;
import com.lmsbackend.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookrentDAOImpl implements BookerentDAO {
    private EntityManager em;

    @Autowired
    public BookrentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Bookrent book,int memberId,int bookId) {
        Member m = em.find(Member.class, memberId);
        if (m == null) {
            throw new ResourceNotFoundException("Member id "+ memberId +" is not existed.");
        }
        if(m != null){
            book.setMember(m);
        }
        Book b = em.find(Book.class, bookId);
        if (b == null) {
            throw new ResourceNotFoundException("Book id "+ bookId +" is not existed.");
        }
        if(b != null){
            book.setBook(b);
        }
        em.persist(book);
    }

    @Override
    public List<ShowDataDTO> getBookrent() {
        String jpql = "select new com.lmsbackend.dto.ShowDataDTO(b.rentId, b.rentDate, b.dueDate, b.status, b.returnDate,b.book) from Bookrent b";
        TypedQuery<ShowDataDTO> query = em.createQuery(jpql, ShowDataDTO.class);
        System.out.println(query.getResultList());
        return query.getResultList();
        //TypedQuery<ShowDataDTO> query = em.createQuery("select b.rentId, b.rentDate, b.dueDate, b.status, b.returnDate from Bookrent b", ShowDataDTO.class);
        //return query.getResultList();
    }

    @Override
    public Bookrent getBookrent(int id) {
        return em.find(Bookrent.class, id);
    }

    @Override
    public void updateBookrent(Bookrent book) {
        em.merge(book);
    }

    @Override
    public void deleteBookrent(int id) {
        em.remove(getBookrent(id));
    }

}
