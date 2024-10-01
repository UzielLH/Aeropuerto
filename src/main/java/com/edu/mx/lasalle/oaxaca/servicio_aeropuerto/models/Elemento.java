package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "elemento")
public class Elemento {

    @Id
    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_carrito", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Carrito carrito;
}
