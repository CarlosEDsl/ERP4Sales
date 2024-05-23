package com.eduardocarlos.ERP4Sales.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = Customer.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Customer {

    final static String TABLE_NAME = "customer";

    @Id
    @Column(name = "cpf", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CPF;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "cell")
    private String cell;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotBlank
    private List<Address> addresses;

}
