package com.lmsbackend.service;

import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    String saveUser(User user, MultipartFile[] files, String memberType);
    List<User> getAllUsers();

    ResponseDTO loginUser(String email, String password);
}
