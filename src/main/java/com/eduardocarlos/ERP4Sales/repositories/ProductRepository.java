package com.eduardocarlos.ERP4Sales.repositories;

import com.eduardocarlos.ERP4Sales.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
