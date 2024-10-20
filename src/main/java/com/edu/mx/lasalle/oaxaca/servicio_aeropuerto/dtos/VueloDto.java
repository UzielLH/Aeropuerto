package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos;

import java.util.List;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VueloDto {
    private int idVuelo;
    private String origen;
    private String destino;
    private String duracion;
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegada;
    private TerminalDto terminal;
    private VehiculoAereoDto datosAvion;
    private TripulanteDto piloto;
    private TripulanteDto copiloto;
    private List<TripulanteDto> sobrecargos;
}
