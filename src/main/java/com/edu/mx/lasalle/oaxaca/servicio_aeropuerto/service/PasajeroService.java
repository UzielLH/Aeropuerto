package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;

@Service
public interface PasajeroService {
    public void registrarPasajero(PasajeroModel pasajeroModel);

    public List<PasajeroModel> obtenerPasajeros();

    public PasajeroModel getPasajeros(int id);

    public void actualizarDatosPasajero(PasajeroModel pasajeroModel, int id);

    public void borrarPasajero(int id);

    public void borrarTodosLosPasajeros();
}