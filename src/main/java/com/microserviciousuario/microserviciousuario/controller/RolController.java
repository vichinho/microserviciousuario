package com.microserviciousuario.microserviciousuario.controller;

import com.microserviciousuario.microserviciousuario.model.Rol;
import com.microserviciousuario.microserviciousuario.model.Permiso;
import com.microserviciousuario.microserviciousuario.repository.RolRepository;
import com.microserviciousuario.microserviciousuario.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @PostMapping
    public Rol createRol(@RequestBody RolRequest rolRequest) {
        Rol rol = new Rol();
        rol.setNombre(rolRequest.getNombre());

        if (rolRequest.getPermisoIds() != null && !rolRequest.getPermisoIds().isEmpty()) {
            List<Permiso> permisos = rolRequest.getPermisoIds().stream()
                    .map(id -> permisoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Permiso no encontrado con id: " + id)))
                    .collect(Collectors.toList());
            rol.setPermisos(permisos);
        }

        return rolRepository.save(rol);
    }
}

record RolRequest(String nombre, List<Integer> permisoIds) {
    public RolRequest(String nombre) {
        this(nombre, null);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getPermisoIds() {
        return permisoIds;
    }
}