package com.eduardocarlos.ERP4Sales.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = SaleItem.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SaleItem {

    final static String TABLE_NAME = "saleItem";

    @Id
    private SaleItemId id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "totalPrice", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "discount")
    private BigDecimal discount;

    @Embeddable
    public class SaleItemId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "sale_id", nullable = false)
        private Sale sale;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;
    }


}

