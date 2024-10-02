/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "piloto")
public class PilotoModel extends TripulacionModel{
    private String rango;
    private String licencia;
    private String tipoAeronaves;
    private String saludMental;

    public PilotoModel() {
    }

    public PilotoModel(String rango, String licencia, String tipoAeronaves, String saludMental) {
        this.rango = rango;
        this.licencia = licencia;
        this.tipoAeronaves = tipoAeronaves;
        this.saludMental = saludMental;
    }

    public PilotoModel(String rango, String licencia, String tipoAeronaves, String saludMental, int idTripulacion, int antiguedad, String turno, int horasVuelo, String nombre, String apellido, LocalDate fechaNac, String genero) {
        super(idTripulacion, antiguedad, turno, horasVuelo, nombre, apellido, fechaNac, genero);
        this.rango = rango;
        this.licencia = licencia;
        this.tipoAeronaves = tipoAeronaves;
        this.saludMental = saludMental;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTipoAeronaves() {
        return tipoAeronaves;
    }

    public void setTipoAeronaves(String tipoAeronaves) {
        this.tipoAeronaves = tipoAeronaves;
    }

    public String getSaludMental() {
        return saludMental;
    }

    public void setSaludMental(String saludMental) {
        this.saludMental = saludMental;
    }
    
    
    
}
