package com.microserviciousuario.microserviciousuario.service;

import com.microserviciousuario.microserviciousuario.model.Usuario;
import com.microserviciousuario.microserviciousuario.model.Rol;
import com.microserviciousuario.microserviciousuario.repository.UsuarioRepository;
import com.microserviciousuario.microserviciousuario.repository.RolRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired  // <- Esto te faltaba
    private RolRepository rolRepository;

    // GET
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // POST
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // PUT
    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setApellido(usuarioActualizado.getApellido());
        // Actualiza otros campos...
        return usuarioRepository.save(usuario);
    }

    public Usuario asignarRol(int usuarioId, int rolId) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    
    Rol rol = rolRepository.findById(rolId)
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    
    usuario.setRol(rol);
    return usuarioRepository.save(usuario);
}

    public Usuario revocarRol(int usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setRol(null);
        return usuarioRepository.save(usuario);
    }
}