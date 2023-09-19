package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate; // in new versions we do not need to define this colum as a date @Column(columnDefinition = "DATE")

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;



}
