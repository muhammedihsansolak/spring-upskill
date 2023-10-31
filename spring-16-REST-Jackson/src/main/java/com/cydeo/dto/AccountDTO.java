package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @JsonIgnore
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @JsonBackReference  // This field is NOT going to be serialized
//    @JsonIgnore
    private UserDTO user;
}
/*  We excluded UserDTO to serialization
{
        "address": "262  Lochmere Lane",
        "country": "United States",
        "state": "Kentucky",
        "city": "LOUISVILLE",
        "age": 35,
        "postalCode": "40289"
    }
 */