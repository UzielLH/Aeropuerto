package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @Column(name = "id_carrito")
    private int idCarrito;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    public Carrito() {
    }

    public Carrito(int idCarrito, String nombre) {
        this.idCarrito = idCarrito;
        this.nombre = nombre;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
