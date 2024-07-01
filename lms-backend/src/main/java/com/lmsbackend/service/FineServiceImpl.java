package com.lmsbackend.service;

import com.lmsbackend.dao.FineDAO;
import com.lmsbackend.dto.FineDTO;
import com.lmsbackend.entity.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class FineServiceImpl implements FineService{

    @Autowired
    private FineDAO fineDAO;

    @Override
    public void createFine(FineDTO fineDTO) {
        Fine fine = new Fine();

        double finePerDay= 1000;
        int daysLate = (int) ChronoUnit.DAYS.between(fineDTO.getDueDate(), fineDTO.getReturnDate());

        if(daysLate > 0){
            int totalDays = (int) (daysLate*finePerDay);

            fine.setAmount(totalDays);
        }else{
            fine.setAmount(0);
        }
        fineDAO.saveFine(fine);

    }
}
