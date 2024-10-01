package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

// EJEMPLO

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String curp;

    @NotNull
    private String apellidos;

    @NotNull
    private String nombre;

    @OneToOne
    @JoinColumn(name = "direccion_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DireccionModel direccion;

    public UsuarioModel() {

    }

    public UsuarioModel(String curp, String apellidos, String nombre) {
        this.curp = curp;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public String getCurp() {
        return this.curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DireccionModel getDireccion() {
        return this.direccion;
    }

    public void setDireccion(DireccionModel direccion) {
        this.direccion = direccion;
    }

}
