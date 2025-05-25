package com.microserviciousuario.microserviciousuario.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rol_id", nullable = true)
    private List<Permiso> permisos;
}