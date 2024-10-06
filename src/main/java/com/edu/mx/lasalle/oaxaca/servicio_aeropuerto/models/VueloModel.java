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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int idVuelo;
    private String origen;
    private String destino;

    private String duracion;
    private Date horaSalida;
    private Date horaLlegada;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "vuelo_id")
    private List<TripulacionModel> tripulacion;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoletoModel> boletos;

    @OneToOne
    @JoinColumn(name = "terminal_id", referencedColumnName = "claveTerminal")
    private TerminalModel terminal;

    @OneToOne
    @JoinColumn(name = "vehiculoAereo_id", referencedColumnName = "matricula")
    private VehiculoAereoModel vehiculoAereo;
}
