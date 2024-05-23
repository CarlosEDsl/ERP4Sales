package com.eduardocarlos.ERP4Sales.repositories;

import com.eduardocarlos.ERP4Sales.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
