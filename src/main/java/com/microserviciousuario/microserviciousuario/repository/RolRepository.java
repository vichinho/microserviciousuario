package com.microserviciousuario.microserviciousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microserviciousuario.microserviciousuario.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
