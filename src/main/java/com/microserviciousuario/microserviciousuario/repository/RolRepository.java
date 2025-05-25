package com.microserviciousuario.microserviciousuario.repository;

import com.microserviciousuario.microserviciousuario.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}