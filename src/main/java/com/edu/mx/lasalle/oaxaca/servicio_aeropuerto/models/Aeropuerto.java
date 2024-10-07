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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 *
 * @author ferrc
 */
@Entity
@Table(name = "aeropuerto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int claveAeropuerto;
    private String nombre;
    private int numeroPistas;
    private String tipoAvion;

    @OneToMany(mappedBy = "aeropuerto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TerminalModel> terminal = new ArrayList<>();
}
