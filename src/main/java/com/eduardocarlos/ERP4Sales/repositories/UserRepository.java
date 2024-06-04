package com.eduardocarlos.ERP4Sales.repositories;

import com.eduardocarlos.ERP4Sales.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    Optional<User> findByUser(String username);

}
