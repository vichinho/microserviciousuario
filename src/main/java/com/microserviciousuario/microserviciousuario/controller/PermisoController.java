package com.microserviciousuario.microserviciousuario.controller;

import com.microserviciousuario.microserviciousuario.model.Permiso;
import com.microserviciousuario.microserviciousuario.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    // Crear permiso: POST /permisos
    @PostMapping
    public Permiso crearPermiso(@RequestBody Permiso permiso) {
        return permisoService.crearPermiso(permiso);
    }

    // Modificar permiso: PUT /permisos/{id}
    @PutMapping("/{id}")
    public Permiso modificarPermiso(@PathVariable int id, @RequestBody Permiso permiso) {
        return permisoService.modificarPermiso(id, permiso);
    }

    // Eliminar permiso: DELETE /permisos/{id}
    @DeleteMapping("/{id}")
    public void eliminarPermiso(@PathVariable int id) {
        permisoService.eliminarPermiso(id);
    }

    // Listar permisos: GET /permisos
    @GetMapping
    public List<Permiso> listarPermisos() {
        return permisoService.listarPermisos();
    }
}