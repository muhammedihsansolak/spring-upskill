package com.cydeo.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity--> creates our table in DB
//spring.jpa.hibernate.ddl-auto=create --> applications.properties
@Entity
public class Employee {

    @Id
    private int id;
    private String name;




}
