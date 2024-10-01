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
import jakarta.persistence.Table;

@Entity
@Table(name = "pasajero")
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pasajero_id")
    private List<EquipajeModel> equipajes;

    public PasajeroModel() {
    }

    public PasajeroModel(int id, String nombre, String apellido, String direccion, LocalDate fechaNacimiento,
            Boolean discapacidad, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

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
