package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paymentDetails")
@Data
@NoArgsConstructor
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;


    @OneToOne(mappedBy = "paymentDetail")//--> we do not want to have a foreign key column for payment since we have a foreign key inside paymentDetail class
    private Payment payment;


    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
