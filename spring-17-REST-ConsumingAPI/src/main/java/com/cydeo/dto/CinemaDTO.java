package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {

    private Long id;
    private String name;
    private String sponsoredName;
    private LocationDTO location;
    private boolean deleted;

}
