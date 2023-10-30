package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCinemaDTO {

    private Long id;
    private LocalDateTime dateTime;
    private MovieDTO movie;
    private CinemaDTO cinema;
    private boolean deleted;

}
