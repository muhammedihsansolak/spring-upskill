package com.cydeo.service.impl;

import com.cydeo.dto.GenreDTO;
import com.cydeo.entity.Genre;
import com.cydeo.repository.GenreRepository;
import com.cydeo.service.GenreService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final MapperUtil mapperUtil;

    public GenreServiceImpl(GenreRepository genreRepository, MapperUtil mapperUtil) {
        this.genreRepository = genreRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public GenreDTO save(GenreDTO genreDTO) {
        return mapperUtil.convert(genreRepository.save(mapperUtil.convert(genreDTO, new Genre())), new GenreDTO());
    }

    @Override
    public void deleteById(Long id) {
        Genre genre = genreRepository.findById(id).get();
        genre.setDeleted(true);
        genreRepository.save(genre);
    }

}
