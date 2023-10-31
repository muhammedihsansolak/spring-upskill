package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference  // This field is going to be serialized
    private AccountDTO account;

}
/*
{
        "email": "josie_story@email.com",
        "username": "josieStory",
        "role": "USER",
        "account": {
            "address": "262  Lochmere Lane",
            "country": "United States",
            "state": "Kentucky",
            "city": "LOUISVILLE",
            "age": 35,
            "postalCode": "40289"
        }
    }
 */