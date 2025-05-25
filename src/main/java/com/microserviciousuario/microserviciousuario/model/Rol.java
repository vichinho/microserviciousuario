package com.microserviciousuario.microserviciousuario.model;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


import java.util.List;

@Entity
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}