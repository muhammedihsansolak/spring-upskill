package com.cydeo.entity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Student {
    private final int ID;
    private final String firstName;
    private final String lastName;
}
