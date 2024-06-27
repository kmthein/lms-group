package com.lmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardCountDTO {
    private Long bookCount;
    private Long genreCount;
    private Long authorCount;
    private Long totalRentCount;
}
