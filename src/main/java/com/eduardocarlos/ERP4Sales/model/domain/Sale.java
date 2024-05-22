package com.eduardocarlos.ERP4Sales.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = Sale.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    final static String TABLE_NAME = "sale";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotBlank
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @NotBlank
    private User user;

    @Column(name = "saleTotal", nullable = false)
    @NotBlank
    private BigDecimal saleTotal;

    @Column(name = "totalPayed", nullable = false)
    @NotBlank
    private BigDecimal totalPayed;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "change")
    private BigDecimal change;

    @Column(name = "sellTime")
    private LocalDateTime sellTime = LocalDateTime.now();

    @Column(name = "lastUpdate")
    private LocalDateTime lastUpdate = LocalDateTime.now();

}
