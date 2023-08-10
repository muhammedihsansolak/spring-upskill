package com.cydeo.entity;

import lombok.Data;

@Data
public class Mentor {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Gender gender;
}
