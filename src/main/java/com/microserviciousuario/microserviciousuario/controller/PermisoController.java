package com.microserviciousuario.microserviciousuario.controller;

import com.microserviciousuario.microserviciousuario.model.Permiso;
import com.microserviciousuario.microserviciousuario.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permisos")
public class PermisoController {
    @Autowired
    private PermisoRepository permisoRepository;

    @GetMapping
    public List<Permiso> getAllPermisos() {
        return permisoRepository.findAll();
    }

    @PostMapping
    public Permiso createPermiso(@RequestBody Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}