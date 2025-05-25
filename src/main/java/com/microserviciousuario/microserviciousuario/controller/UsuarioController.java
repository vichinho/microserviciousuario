package com.microserviciousuario.microserviciousuario.controller;

import com.microserviciousuario.microserviciousuario.model.Rol;
import com.microserviciousuario.microserviciousuario.model.Usuario;
import com.microserviciousuario.microserviciousuario.repository.UsuarioRepository;
import com.microserviciousuario.microserviciousuario.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository; // Inyectamos RolRepository

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{usuarioId}/rol/{rolId}")
    public Usuario assignRoleToUser(@PathVariable int usuarioId, @PathVariable int rolId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));
        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + rolId));
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{usuarioId}/rol")
    public Usuario removeRoleFromUser(@PathVariable int usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));
        usuario.setRol(null);
        return usuarioRepository.save(usuario);
    }
}