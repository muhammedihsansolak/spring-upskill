package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String code;
    private BigDecimal transactionCode;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

    //one merchant can have more than one payment so it is @OneToMany and field should accept more than one object
    //In Payment class we put @ManyToOne so we do not have a separate table for merchants_payments. thus many payments can have many merchants and it is shown in payment table
//    @OneToMany(mappedBy = "merchant")
//    private List<Payment> payment;


    public Merchant(String name, String code, BigDecimal transactionCode, BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionCode = transactionCode;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
