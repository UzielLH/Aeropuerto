/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author tokay
 */
@Entity
@Table(name = "boleto")
public class BoletoModel {
    private int idBoleto;
    private String asiento;
    private float costo;
    @OneToOne(mappedBy = "idPasajero")
    private PasajeroModel pasajeroModel;
    
    @OneToOne(mappedBy = "idVuelo")
    private VueloModel vueloModel;
    
    @OneToOne
    @JoinColumn(name = "vuelo_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VueloModel vuelo;

    public BoletoModel(int idBoleto, String asiento, float costo, PasajeroModel pasajeroModel, VueloModel vueloModel) {
        this.idBoleto = idBoleto;
        this.asiento = asiento;
        this.costo = costo;
        this.pasajeroModel = pasajeroModel;
        this.vueloModel = vueloModel;
    }

    public BoletoModel() {
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public PasajeroModel getPasajeroModel() {
        return pasajeroModel;
    }

    public void setPasajeroModel(PasajeroModel pasajeroModel) {
        this.pasajeroModel = pasajeroModel;
    }

    public VueloModel getVueloModel() {
        return vueloModel;
    }

    public void setVueloModel(VueloModel vueloModel) {
        this.vueloModel = vueloModel;
    }
    
    
    
}
