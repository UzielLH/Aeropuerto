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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "tripulacion")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
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
