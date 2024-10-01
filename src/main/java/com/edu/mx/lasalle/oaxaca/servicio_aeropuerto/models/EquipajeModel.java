package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipaje")
public class EquipajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private Double altura;

    private Double ancho;

    private int idPasajero;

    private String tipo;

    public EquipajeModel() {
    }

    public EquipajeModel(int id, Double altura, Double ancho, String tipo, int idPasajero) {
        this.id = id;
        this.altura = altura;
        this.ancho = ancho;
        this.tipo = tipo;
        this.idPasajero = idPasajero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
