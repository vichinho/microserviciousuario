package com.microserviciousuario.microserviciousuario.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
}