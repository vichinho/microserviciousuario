package com.microserviciousuario.microserviciousuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microserviciousuario.microserviciousuario.model.Rol;
import com.microserviciousuario.microserviciousuario.repository.RolRepository;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }
}