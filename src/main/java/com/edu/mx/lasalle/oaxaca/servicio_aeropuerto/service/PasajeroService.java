package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;

@Service
public interface PasajeroService {
    PasajeroModel registrarPasajero(PasajeroModel pasajeroModel);

    List<PasajeroModel> obtenerPasajeros();

    Optional<PasajeroModel> getPasajeros(int id);

    Optional<PasajeroModel> actualizarDatosPasajero(PasajeroModel pasajeroModel, int id);

    Optional<PasajeroModel> borrarPasajero(int id);

    void borrarTodosLosPasajeros();
}