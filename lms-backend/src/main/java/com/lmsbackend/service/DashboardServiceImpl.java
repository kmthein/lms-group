package com.lmsbackend.service;

import com.lmsbackend.dao.AuthorDAO;
import com.lmsbackend.dao.BookDAO;
import com.lmsbackend.dao.BookrentDAO;
import com.lmsbackend.dao.GenreDAO;
import com.lmsbackend.dto.DashboardCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    private BookDAO bookDAO;
    private GenreDAO genreDAO;
    private AuthorDAO authorDAO;
    private BookrentDAO bookrentDAO;

    public DashboardServiceImpl(BookDAO bookDAO, GenreDAO genreDAO, AuthorDAO authorDAO, BookrentDAO bookrentDAO) {
        this.bookDAO = bookDAO;
        this.genreDAO = genreDAO;
        this.authorDAO = authorDAO;
        this.bookrentDAO = bookrentDAO;
    }

    @Override
    public DashboardCountDTO getAllCounts() {
        DashboardCountDTO dashboardCountDTO = bookDAO.getAllCount();
        return dashboardCountDTO;
    }
}
