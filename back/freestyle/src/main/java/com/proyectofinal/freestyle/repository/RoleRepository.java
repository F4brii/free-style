package com.proyectofinal.freestyle.repository;

import com.proyectofinal.freestyle.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
