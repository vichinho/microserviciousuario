package com.microserviciousuario.microserviciousuario.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Permiso> permisos;
}