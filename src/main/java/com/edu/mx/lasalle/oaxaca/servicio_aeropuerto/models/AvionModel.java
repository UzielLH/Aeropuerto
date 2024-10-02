/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "avionModel")
public class AvionModel extends VehiculoAereoModel {
    
    private String aerolinea;
    private String tipoMotor;
    private int puertas;
    private String tipo;

    public AvionModel(int matricula, String model, String serie, int capacidad, String color, String estado, String antiguedad, int llantas, String tanque, float distancia, String aerolinea, String tipoMotor, int puertas, String tipo) {
        super(matricula, model, serie, capacidad, color, estado, antiguedad, llantas, tanque, distancia);
        this.aerolinea = aerolinea;
        this.tipoMotor = tipoMotor;
        this.puertas = puertas;
        this.tipo = tipo;
    }

    public AvionModel() {
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getPuertas() {
        return puertas;
    }

    public String getTipo() {
        return tipo;
    }
    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getSerie() {
        return serie;
    }

    @Override
    public int getCapacidad() {
        return capacidad;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public String getEstado() {
        return estado;
    }
    @Override
    public String getAntiguedad() {
        return antiguedad;
    }
    @Override
    public int getLlantas() {
        return llantas;
    }
    @Override
    public String getTanque() {
        return tanque;
    }
    @Override
    public float getDistancia() {
        return distancia;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public void setSerie(String serie) {
        this.serie = serie;
    }
    @Override
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Override
    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
    @Override
    public void setLlantas(int llantas) {
        this.llantas = llantas;
    }
    @Override
    public void setTanque(String tanque) {
        this.tanque = tanque;
    }
    @Override
    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    
}
