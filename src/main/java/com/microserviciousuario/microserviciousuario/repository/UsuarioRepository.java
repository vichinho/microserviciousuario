package com.microserviciousuario.microserviciousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microserviciousuario.microserviciousuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}