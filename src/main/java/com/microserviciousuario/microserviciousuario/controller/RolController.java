package com.microserviciousuario.microserviciousuario.controller;

import com.microserviciousuario.microserviciousuario.model.Rol;
import com.microserviciousuario.microserviciousuario.service.RolService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/roles")

public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listarTodos();
    }

    @GetMapping("/{id}")
    public Rol obtenerRol(@PathVariable int id) {
        return rolService.buscarPorId(id);
    }

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return rolService.crearRol(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable int id, @RequestBody Rol rol) {
        return rolService.actualizarRol(id, rol);
    }

    @PutMapping("/{rolId}/asignar-permisos") // Sin barra al final
    public Rol asignarPermisos(@PathVariable int rolId,@RequestBody List<Integer> permisosIds) {
        return rolService.asignarPermisos(rolId, permisosIds);
    }

    @DeleteMapping("/{rolId}/quitar-permiso/{permisoId}")
    public Rol quitarPermisoDeRol(@PathVariable int rolId,@PathVariable int permisoId) {
        return rolService.quitarPermiso(rolId, permisoId);
    }
}