package com.microserviciousuario.microserviciousuario.service;

import com.microserviciousuario.microserviciousuario.model.Permiso;
import com.microserviciousuario.microserviciousuario.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    // Crear permiso
    public Permiso crearPermiso(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    // Modificar permiso (CORREGIDO)
    public Permiso modificarPermiso(int id, Permiso permisoActualizado) {
        Permiso permisoExistente = permisoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Permiso no encontrado con ID: " + id));
        
        // Actualiza solo los campos necesarios
        permisoExistente.setNombre(permisoActualizado.getNombre());
        permisoExistente.setDescription(permisoActualizado.getDescription());
        
        return permisoRepository.save(permisoExistente); // Guarda los cambios
    }

    // Eliminar permiso
    public void eliminarPermiso(int id) {
        permisoRepository.deleteById(id);
    }

    // Listar permisos (CORREGIDO)
    public List<Permiso> listarPermisos() {
        return permisoRepository.findAll(); // Retorna todos los permisos de la base de datos
    }
}