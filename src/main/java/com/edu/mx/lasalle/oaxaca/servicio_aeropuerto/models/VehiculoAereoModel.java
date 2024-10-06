/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "vehiculoAereoModel")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class VehiculoAereoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    int matricula;
    String model;
    String serie;
    int capacidad;
    String color;
    String estado;
    String antiguedad;
    int llantas;
    String tanque;
    float distancia;

    @OneToOne(mappedBy = "vehiculoAereo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private VueloModel vuelo;
}
