package com.microserviciousuario.microserviciousuario.repository;


import com.microserviciousuario.microserviciousuario.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}