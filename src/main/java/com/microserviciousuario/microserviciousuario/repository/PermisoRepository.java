package com.microserviciousuario.microserviciousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microserviciousuario.microserviciousuario.model.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}
