/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "copiloto")
public class CopilotoModel extends TripulacionModel{
    private String rango;
    private float TiempoRestantePiloto; //Horas faltantes para convertirse

    public CopilotoModel() {
    }

    public CopilotoModel(String rango, float TiempoRestantePiloto) {
        this.rango = rango;
        this.TiempoRestantePiloto = TiempoRestantePiloto;
    }

    public CopilotoModel(String rango, float TiempoRestantePiloto, int idTripulacion, int antiguedad, String turno, int horasVuelo, String nombre, String apellido, LocalDate fechaNac, String genero) {
        super(idTripulacion, antiguedad, turno, horasVuelo, nombre, apellido, fechaNac, genero);
        this.rango = rango;
        this.TiempoRestantePiloto = TiempoRestantePiloto;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public float getTiempoRestantePiloto() {
        return TiempoRestantePiloto;
    }

    public void setTiempoRestantePiloto(float TiempoRestantePiloto) {
        this.TiempoRestantePiloto = TiempoRestantePiloto;
    }
    
    
}
