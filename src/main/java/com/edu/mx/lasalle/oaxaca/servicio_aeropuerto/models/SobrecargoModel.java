/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "sobrecargo")
public class SobrecargoModel extends TripulacionModel{
    private List<String> idiomas;       // Especifica que la lista contiene objetos de tipo String
    private List<String> certificados;

    public SobrecargoModel() {
    }

    public SobrecargoModel(List<String> idiomas, List<String> certificados) {
        this.idiomas = idiomas;
        this.certificados = certificados;
    }

    public SobrecargoModel(List<String> idiomas, List<String> certificados, int idTripulacion, int antiguedad, String turno, int horasVuelo, String nombre, String apellido, LocalDate fechaNac, String genero) {
        super(idTripulacion, antiguedad, turno, horasVuelo, nombre, apellido, fechaNac, genero);
        this.idiomas = idiomas;
        this.certificados = certificados;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public List<String> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<String> certificados) {
        this.certificados = certificados;
    }
    
    
}
