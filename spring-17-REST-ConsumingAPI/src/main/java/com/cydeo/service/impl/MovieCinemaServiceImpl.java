package com.cydeo.service.impl;

import com.cydeo.dto.MovieCinemaDTO;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.MovieCinemaRepository;
import com.cydeo.service.MovieCinemaService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieCinemaServiceImpl implements MovieCinemaService {

    private final MovieCinemaRepository movieCinemaRepository;
    private final MapperUtil mapperUtil;

    public MovieCinemaServiceImpl(MovieCinemaRepository movieCinemaRepository, MapperUtil mapperUtil) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<MovieCinemaDTO> findAll() {

        List<MovieCinema> list = movieCinemaRepository.findAll();
        List<MovieCinemaDTO> list2 = list.stream().map(movieCinema -> mapperUtil.convert(movieCinema, new MovieCinemaDTO())).collect(Collectors.toList());

        return list2;
    }

    @Override
    public MovieCinemaDTO findById(Long id) {
        return mapperUtil.convert(movieCinemaRepository.findById(id).get(), new MovieCinemaDTO());
    }

}
