/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
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
import java.util.Date;
import java.util.List;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "vuelo")
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
    
    @OneToOne(mappedBy = "boleto")
    private BoletoModel boleto;
    
    @OneToOne(mappedBy = "terminal")
    private TerminalModel terminal;
    
    @OneToOne(mappedBy = "vehiculoAereo")
    private VehiculoAereoModel vehiculoAereo;

    public VueloModel() {
    }

    
    public VueloModel(int idVuelo, String origen, String destino, String duracion, Date horaSalida, Date horaLlegada, List<TripulacionModel> tripulacion, BoletoModel boleto, TerminalModel terminal, VehiculoAereoModel vehiculoAereo) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.tripulacion = tripulacion;
        this.boleto = boleto;
        this.terminal = terminal;
        this.vehiculoAereo = vehiculoAereo;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public List<TripulacionModel> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(List<TripulacionModel> tripulacion) {
        this.tripulacion = tripulacion;
    }

    public BoletoModel getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoModel boleto) {
        this.boleto = boleto;
    }

    public TerminalModel getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalModel terminal) {
        this.terminal = terminal;
    }

    public VehiculoAereoModel getVehiculoAereo() {
        return vehiculoAereo;
    }

    public void setVehiculoAereo(VehiculoAereoModel vehiculoAereo) {
        this.vehiculoAereo = vehiculoAereo;
    }
    
    
}
