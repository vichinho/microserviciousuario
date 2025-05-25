package com.microserviciousuario.microserviciousuario.controller;

import com.microserviciousuario.microserviciousuario.model.Usuario;
import com.microserviciousuario.microserviciousuario.service.UsuarioService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // GET: Listar todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    // GET: Obtener un usuario por ID
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable int id) {
        return usuarioService.buscarPorId(id);
    }

    // POST: Crear un nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    // PUT: Actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    // PUT: Asignar rol a usuario
    @PutMapping("/{usuarioId}/asignar-rol")
    public Usuario asignarRol(
    @PathVariable int usuarioId,
    @RequestBody Map<String, Integer> request // Cambio clave: acepta un mapa con el ID del rol
    ){
    return usuarioService.asignarRol(usuarioId, request.get("rolId")); // Extrae el ID del rol
    }

    // PUT: Revocar rol de usuario
    @PutMapping("/{usuarioId}/revocar-rol")
    public Usuario revocarRol(@PathVariable int usuarioId) {
        return usuarioService.revocarRol(usuarioId);
    }
}