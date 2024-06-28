package com.lmsbackend.controller;

import com.lmsbackend.dto.DashboardCountDTO;
import com.lmsbackend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/all-count")
    public DashboardCountDTO getAllCounts() {
        return dashboardService.getAllCounts();
    }
}
