/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "tripulacion")
@Inheritance(strategy = InheritanceType.JOINED)
public class TripulacionModel implements Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTripulacion;

    private int antiguedad;
    private String turno;
    private int horasVuelo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String genero;

    public TripulacionModel() {
    }

    public TripulacionModel(int idTripulacion, int antiguedad, String turno, int horasVuelo, String nombre,
            String apellido, LocalDate fechaNac, String genero) {
        this.idTripulacion = idTripulacion;
        this.antiguedad = antiguedad;
        this.turno = turno;
        this.horasVuelo = horasVuelo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.genero = genero;
    }

    public int getIdTripulacion() {
        return idTripulacion;
    }

    public void setIdTripulacion(int idTripulacion) {
        this.idTripulacion = idTripulacion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void viajar() {
        System.out.println("Tripulacion viajando");
    }

    @Override
    public void abordar() {
        System.out.println("Tripulacion abordando");
    }

    @Override
    public void dormir() {
        System.out.println("Tripulacion durmiendo");
    }

    @Override
    public void checkIn() {
        System.out.println("Tripulacion haciendo Check-In");
    }

    @Override
    public void irBano() {
        System.out.println("Tripulacion en el bano");
    }

    @Override
    public void comer() {
        System.out.println("Tripulacion comiendo");
    }

}
