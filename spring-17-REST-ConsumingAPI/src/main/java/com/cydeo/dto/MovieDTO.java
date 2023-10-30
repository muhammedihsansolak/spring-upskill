package com.cydeo.dto;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private LocalDate releaseDate;
    private Integer duration;
    private String summary;
    private MovieType type;
    private MovieState state;
    private BigDecimal price;
    private List<GenreDTO> genreList;
    private boolean deleted;

}
