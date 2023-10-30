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
public class TicketDTO {

    private Integer seatNumber;
    private Integer rowNumber;
    private LocalDateTime dateTime;
    private MovieCinemaDTO movieCinema;
    private UserDTO userAccount;
    private boolean deleted;

}
