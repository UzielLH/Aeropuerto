package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos;

public record VehiculoAereoDto(
        int matricula,
        String model,
        String serie,
        int capacidad,
        String estado,
        String antiguedad,
        int llantas,
        String tanque,
        float distancia) {

}
