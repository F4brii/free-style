package com.proyectofinal.freestyle.repository;

import com.proyectofinal.freestyle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
