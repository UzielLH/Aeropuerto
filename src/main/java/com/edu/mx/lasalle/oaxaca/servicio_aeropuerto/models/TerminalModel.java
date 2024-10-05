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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "terminal")
public class TerminalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int claveTerminal;
    private int capacidad;
    private boolean disponible;

    @OneToOne(mappedBy = "terminal", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private VueloModel vuelo;

    public TerminalModel(int claveTerminal, int capacidad, boolean disponible) {
        this.claveTerminal = claveTerminal;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    public TerminalModel() {
    }

    public int getClaveTerminal() {
        return claveTerminal;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setClaveTerminal(int claveTerminal) {
        this.claveTerminal = claveTerminal;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
