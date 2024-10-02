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
@Table(name = "avionetaModel")
public class AvionetaModel extends VehiculoAereoModel {
    
    private int numeroMotores;
    private String tipoPista;
    private String clasificacion;
    private String tipoCombustion;

    // Constructor con parámetros
    public AvionetaModel(int matricula, String model, String serie, int capacidad, String color, String estado, String antiguedad, int llantas, String tanque, float distancia,
                         int numeroMotores, String tipoPista, String clasificacion, String tipoCombustion) {
        super(matricula, model, serie, capacidad, color, estado, antiguedad, llantas, tanque, distancia);
        this.numeroMotores = numeroMotores;
        this.tipoPista = tipoPista;
        this.clasificacion = clasificacion;
        this.tipoCombustion = tipoCombustion;
    }

    // Constructor vacío
    public AvionetaModel() {
        super();
    }

    // Getters y Setters para los atributos propios
    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }

    public String getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(String tipoPista) {
        this.tipoPista = tipoPista;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipoCombustion() {
        return tipoCombustion;
    }

    public void setTipoCombustion(String tipoCombustion) {
        this.tipoCombustion = tipoCombustion;
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

