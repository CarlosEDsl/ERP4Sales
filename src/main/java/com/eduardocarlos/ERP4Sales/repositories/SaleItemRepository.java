package com.eduardocarlos.ERP4Sales.repositories;

import com.eduardocarlos.ERP4Sales.model.domain.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, SaleItem> {
}
