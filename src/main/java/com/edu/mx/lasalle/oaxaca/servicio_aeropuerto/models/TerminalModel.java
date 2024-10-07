/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "terminal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerminalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int claveTerminal;
    private int capacidad;
    private boolean disponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "claveAeropuerto")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "nombre", "numeroPistas", "tipoAvion", "terminal" })
    private Aeropuerto aeropuerto;

    @JsonIgnore
    @OneToOne(mappedBy = "terminal", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private VueloModel vuelo;
}
