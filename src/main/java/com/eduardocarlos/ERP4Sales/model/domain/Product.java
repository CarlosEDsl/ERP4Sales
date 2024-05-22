package com.eduardocarlos.ERP4Sales.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = Product.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    public static final String TABLE_NAME = "product";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "price", nullable = false)
    @NotBlank
    private BigDecimal price;

    @Column(name = "amount", nullable = false)
    @NotBlank
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "creationDate")
    private LocalDateTime creationDate = LocalDateTime.now();

}
