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
@Table(name = "helicopteroModel")
public class HelicopteroModel extends VehiculoAereoModel {
    private int helices;
    private String tipo;

    // Constructor con parámetros
    public HelicopteroModel(int matricula, String model, String serie, int capacidad, String color, String estado, String antiguedad, int llantas, String tanque, float distancia,
                            int helices, String tipo) {
        super(matricula, model, serie, capacidad, color, estado, antiguedad, llantas, tanque, distancia);
        this.helices = helices;
        this.tipo = tipo;
    }

    // Constructor vacío
    public HelicopteroModel() {
        super();
    }

    // Getters y Setters para los atributos propios
    public int getHelices() {
        return helices;
    }

    public void setHelices(int helices) {
        this.helices = helices;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Overriding Getters y Setters heredados
    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setMatricula(int matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public String getSerie() {
        return super.getSerie();
    }

    @Override
    public void setSerie(String serie) {
        super.setSerie(serie);
    }

    @Override
    public int getCapacidad() {
        return super.getCapacidad();
    }

    @Override
    public void setCapacidad(int capacidad) {
        super.setCapacidad(capacidad);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String getEstado() {
        return super.getEstado();
    }

    @Override
    public void setEstado(String estado) {
        super.setEstado(estado);
    }

    @Override
    public String getAntiguedad() {
        return super.getAntiguedad();
    }

    @Override
    public void setAntiguedad(String antiguedad) {
        super.setAntiguedad(antiguedad);
    }

    @Override
    public int getLlantas() {
        return super.getLlantas();
    }

    @Override
    public void setLlantas(int llantas) {
        super.setLlantas(llantas);
    }

    @Override
    public String getTanque() {
        return super.getTanque();
    }

    @Override
    public void setTanque(String tanque) {
        super.setTanque(tanque);
    }

    @Override
    public float getDistancia() {
        return super.getDistancia();
    }

    @Override
    public void setDistancia(float distancia) {
        super.setDistancia(distancia);
    }
}