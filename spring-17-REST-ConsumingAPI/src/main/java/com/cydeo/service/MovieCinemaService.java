package com.cydeo.service;

import com.cydeo.dto.MovieCinemaDTO;

import java.util.List;

public interface MovieCinemaService {

    List<MovieCinemaDTO> findAll();
    MovieCinemaDTO findById(Long id);

}
