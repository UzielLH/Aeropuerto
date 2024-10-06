package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEquipaje;

    private Double altura;

    private Double ancho;

    private String tipo;
}
