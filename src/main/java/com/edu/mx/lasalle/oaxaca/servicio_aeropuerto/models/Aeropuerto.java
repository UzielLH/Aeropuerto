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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "aeropuerto")

public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    private int claveAeropuerto;
    private String nombre;
    private int numeroPistas;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "claveTerminal")
    
    private List<TerminalModel> terminal;

    public Aeropuerto(int claveAeropuerto, String nombre, int numeroPistas, List<TerminalModel> terminal, String tipoAvion) {
        this.claveAeropuerto = claveAeropuerto;
        this.nombre = nombre;
        this.numeroPistas = numeroPistas;
        this.terminal = terminal;
        this.tipoAvion = tipoAvion;
    }

    public Aeropuerto() {
    }

    
    
    
    public List<TerminalModel> getTerminal() {
        return terminal;
    }

    public void setTerminal(List<TerminalModel> terminal) {
        this.terminal = terminal;
    }
    
    public int getClaveAeropuerto() {
        return claveAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPistas() {
        return numeroPistas;
    }

    public String getTipoAvion() {
        return tipoAvion;
    }
    public String tipoAvion;

    public void setClaveAeropuerto(int claveAeropuerto) {
        this.claveAeropuerto = claveAeropuerto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }
    
 }

