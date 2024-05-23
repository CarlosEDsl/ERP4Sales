package com.eduardocarlos.ERP4Sales.repositories;

import com.eduardocarlos.ERP4Sales.model.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
