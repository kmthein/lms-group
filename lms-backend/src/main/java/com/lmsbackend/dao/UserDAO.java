package com.lmsbackend.dao;

import com.lmsbackend.entity.User;

import java.util.List;

public interface UserDAO {
    User save(User user);

    List<User> findAll();
}
