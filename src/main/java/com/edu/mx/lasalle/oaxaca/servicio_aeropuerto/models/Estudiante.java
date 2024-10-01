package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "curp")
    private String curp;

    @NotNull
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "estudiante_curso", joinColumns = @JoinColumn(name = "clave_estudiante"), inverseJoinColumns = @JoinColumn(name = "clave_curso"))
    private Set<Curso> cursos = new HashSet<>();
}
