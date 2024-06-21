package com.lmsbackend.dao;

import com.lmsbackend.dto.GenreBookCountDTO;
import com.lmsbackend.entity.Genre;

import java.util.List;

public interface GenreDAO {
    void saveGenre(Genre genre);

    Genre findById(int id);

    List<Genre> findAll();
   void updateGenre(Genre genre);

   void deleteGenre(int id);
   List<GenreBookCountDTO> getGenreBookCountDTO();

}
