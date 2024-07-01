package com.lmsbackend.service;

import com.lmsbackend.dto.FineDTO;

import java.time.LocalDate;

public interface FineService {
    void createFine(FineDTO fineDTO );
}
