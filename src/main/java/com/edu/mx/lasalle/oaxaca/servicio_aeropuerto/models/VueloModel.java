/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegada;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({ "vuelo" })
    private List<TripulacionModel> tripulacion;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoletoModel> boletos;

    @OneToOne
    @JoinColumn(name = "terminal_id", referencedColumnName = "claveTerminal")
    @JsonIgnoreProperties({ "vuelo", "aeropuerto" })
    private TerminalModel terminal;

    @OneToOne
    @JoinColumn(name = "vehiculoAereo_id", referencedColumnName = "matricula")
    @JsonIgnoreProperties({ "vuelo" })
    private VehiculoAereoModel vehiculoAereo;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Transient
    private List<Integer> tripulacionIds;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Transient
    private Integer terminalId;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Transient
    private Integer vehiculoAereoId;
}