package com.lmsbackend.dao;

import com.lmsbackend.entity.Fine;

import java.util.List;

public interface FineDAO {
    void saveFine(Fine fine);

    Fine getById(int id);

    List<Fine> findAll();

    void updateFine(Fine fine);

    void deleteFine(int id);


}
