package com.microserviciousuario.microserviciousuario.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String apellido;
    private String telefono;
    private String rut;
    private String email;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}