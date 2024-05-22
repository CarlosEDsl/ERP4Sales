package com.eduardocarlos.ERP4Sales.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Address.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    static final String TABLE_NAME = "address";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", length = 100)
    private String street;

    @ManyToOne
    @JoinColumn(name = "customer_cpf", nullable = false, updatable = false)
    private Customer customer;

    @Column(name = "city", nullable = false, length = 50)
    @NotBlank
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "postalCode", length = 10)
    private String postalCode;

    @Column(name = "number")
    private Integer number;

    @Column(name = "country", nullable = false, length = 50)
    @NotBlank
    private String country;

}
