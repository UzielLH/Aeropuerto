package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "equipaje")
public class EquipajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEquipaje;

    private Double altura;

    private Double ancho;

    private String tipo;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PasajeroModel pasajeroModel;

    public EquipajeModel() {
    }

    public EquipajeModel(int id, Double altura, Double ancho, int idPasajero, String tipo, PasajeroModel pasajeroModel) {
        this.idEquipaje = idEquipaje;
        this.altura = altura;
        this.ancho = ancho;
        this.tipo = tipo;
        this.pasajeroModel = pasajeroModel;
    }

    

    public int getId() {
        return idEquipaje;
    }

    public void setId(int id) {
        this.idEquipaje = idEquipaje;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PasajeroModel getPasajeroModel() {
        return pasajeroModel;
    }

    public void setPasajeroModel(PasajeroModel pasajeroModel) {
        this.pasajeroModel = pasajeroModel;
    }
}
