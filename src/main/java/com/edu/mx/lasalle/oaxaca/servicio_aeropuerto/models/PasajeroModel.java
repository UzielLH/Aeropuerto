package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import java.time.LocalDate;

import java.util.List;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pasajero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasajeroModel implements Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Boolean discapacidad;
    private String nacionalidad;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "boleto_id", referencedColumnName = "idBoleto")
    private BoletoModel boletoModel;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pasajero_id")
    private List<EquipajeModel> equipajes;

    @Override
    public void viajar() {
        System.out.println("Pasajero viajando");
    }

    @Override
    public void abordar() {
        System.out.println("Pasajero abordando");
    }

    @Override
    public void dormir() {
        System.out.println("Pasajero durmiendo");
    }

    @Override
    public void checkIn() {
        System.out.println("Pasajero haciendo Check-In");
    }

    @Override
    public void irBano() {
        System.out.println("Pasajero yendo al bano");
    }

    @Override
    public void comer() {
        System.out.println("Pasajero comiendo");
    }

}
