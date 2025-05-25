package com.microserviciousuario.microserviciousuario.repository;

import com.microserviciousuario.microserviciousuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}