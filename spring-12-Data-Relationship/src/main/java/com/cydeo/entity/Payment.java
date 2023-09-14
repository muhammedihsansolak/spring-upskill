package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;


    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status status;

//    @JoinColumn(name = "paymentDetailId")//if we want we can change the table name
    //one payment object can have just one paymentDetail
//    @OneToOne(cascade = CascadeType.ALL)//--> this means if we create a Payment object, PaymentDetail object will be created automatically. When parent created child will be created too
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private PaymentDetail paymentDetail;

    //many payments can have one merchant
    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    public Payment(LocalDate createdDate, BigDecimal amount, Status status) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.status = status;
    }
}
