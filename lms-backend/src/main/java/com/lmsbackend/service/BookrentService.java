package com.lmsbackend.service;

import com.lmsbackend.dto.RentDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Bookrent;

import java.util.List;

public interface BookrentService {
    ResponseDTO makeBookrent(int memberId, int bookId);

    ResponseDTO updateBookrent(RentDTO rentDTO);

    List<Bookrent> getAllBookrents();
}
