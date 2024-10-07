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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "boleto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idBoleto;
    private String asiento;
    private float costo;

    @OneToOne(mappedBy = "boletoModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private PasajeroModel pasajeroModel;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    @JsonIgnoreProperties({ "tripulacion", "boletos", "vehiculoAereo", "origen", "destino", "duracion", "horaSalida",
            "horaLlegada", "terminal" })
    private VueloModel vuelo;
}
