package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {
}
