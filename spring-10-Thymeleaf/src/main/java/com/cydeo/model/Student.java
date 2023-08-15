package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String state;
}
