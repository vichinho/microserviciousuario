package com.microserviciousuario.microserviciousuario.service;


import com.microserviciousuario.microserviciousuario.model.Permiso;
import com.microserviciousuario.microserviciousuario.model.Rol;
import com.microserviciousuario.microserviciousuario.repository.PermisoRepository;
import com.microserviciousuario.microserviciousuario.repository.RolRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private PermisoRepository permisoRepository;

    // GET: Listar todos los roles
    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    // GET: Buscar rol por ID
    public Rol buscarPorId(int id) {
        return rolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    // POST: Crear un nuevo rol
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // PUT: Actualizar rol existente
    public Rol actualizarRol(int id, Rol rolActualizado) {
        Rol rol = rolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rol.setNombre(rolActualizado.getNombre());
        return rolRepository.save(rol);
    }

    // PUT: Asignar permiso a un rol
    @Transactional
public Rol asignarPermisos(int rolId, List<Integer> permisosIds) {
    Rol rol = rolRepository.findById(rolId)
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

    List<Permiso> permisos = permisoRepository.findAllById(permisosIds);
    
    // Asigna el rol a cada permiso
    permisos.forEach(permiso -> permiso.setRol(rol));
    permisoRepository.saveAll(permisos); // Guarda todos los permisos actualizados

    return rolRepository.save(rol);
}
@Transactional
public Rol quitarPermiso(int rolId, int permisoId) {
    // 1. Buscar el rol y el permiso
    Rol rol = rolRepository.findById(rolId)
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    
    Permiso permiso = permisoRepository.findById(permisoId)
        .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));

    // 2. Validar que el permiso pertenezca al rol
    if (permiso.getRol() == null || permiso.getRol().getId() != rolId) {
        throw new RuntimeException("El permiso no está asignado a este rol");
    }

    // 3. Quitar la relación
    permiso.setRol(null); // Elimina la referencia al rol
    permisoRepository.save(permiso);

    // 4. Opcional: Actualizar la lista de permisos del rol (si usas fetch EAGER)
    rol.getPermisos().removeIf(p -> p.getId() == permisoId);

    return rolRepository.save(rol);
}
}