package com.microserviciousuario.microserviciousuario.model;

import jakarta.persistence.*;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String description;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    @JsonIgnore
    private Rol rol;
}