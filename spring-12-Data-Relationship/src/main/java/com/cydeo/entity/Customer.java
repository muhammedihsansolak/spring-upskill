package com.cydeo.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

}
