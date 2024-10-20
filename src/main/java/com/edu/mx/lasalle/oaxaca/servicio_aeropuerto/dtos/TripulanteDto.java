package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos;

import java.time.LocalDate;

public record TripulanteDto(
        int idTripulacion,
        int antiguedad,
        String turno,
        int horasVuelo,
        String nombre,
        String apellido,
        LocalDate fechaNac,
        String genero) {

}
