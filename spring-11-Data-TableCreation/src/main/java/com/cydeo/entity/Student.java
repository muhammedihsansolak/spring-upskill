package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//spring.jpa.hibernate.ddl-auto=create
@Entity
@Table(name = "students")
public class Student {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//postgreSQL creates primary keys
    private Long id;

    @Column(name = "Full_Name")//column name
    private String name;
    private String email;

    @Column(columnDefinition = "DATE")//if we have date, time oe dateTime
    private LocalDate birthDay;

    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDayTime;

    @Enumerated(EnumType.STRING)//if we have enum
    private Gender gender;

    @Transient//omit this field while creating table. This field won't be shown
    private String city;

}
