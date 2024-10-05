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

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "vehiculoAereoModel")
@Inheritance(strategy = InheritanceType.JOINED)
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

    public VehiculoAereoModel(int matricula, String model, String serie, int capacidad, String color, String estado,
            String antiguedad, int llantas, String tanque, float distancia) {
        this.matricula = matricula;
        this.model = model;
        this.serie = serie;
        this.capacidad = capacidad;
        this.color = color;
        this.estado = estado;
        this.antiguedad = antiguedad;
        this.llantas = llantas;
        this.tanque = tanque;
        this.distancia = distancia;
    }

    public VehiculoAereoModel() {
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setLlantas(int llantas) {
        this.llantas = llantas;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getModel() {
        return model;
    }

    public String getSerie() {
        return serie;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getColor() {
        return color;
    }

    public String getEstado() {
        return estado;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public int getLlantas() {
        return llantas;
    }

    public String getTanque() {
        return tanque;
    }

    public float getDistancia() {
        return distancia;
    }

}
