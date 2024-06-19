package com.lmsbackend.dao;

import com.lmsbackend.entity.Member;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void save(Member member) {
        em.persist(member);
    }
}
