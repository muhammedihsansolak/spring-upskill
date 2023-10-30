package com.cydeo.service;

import com.cydeo.dto.GenreDTO;

public interface GenreService {

    GenreDTO save(GenreDTO genreDTO);
    void deleteById(Long id);

}
