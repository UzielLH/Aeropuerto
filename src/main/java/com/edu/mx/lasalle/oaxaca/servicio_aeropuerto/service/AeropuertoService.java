/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Aeropuerto;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface AeropuertoService {
    Aeropuerto registrarAeropuerto(Aeropuerto aeropuerto);

    List<Aeropuerto> obtenerAeropuertos();

    Optional<Aeropuerto> getAeropuerto(int claveAeropuerto);

    Optional<Aeropuerto> actualizarDatosAeropuerto(Integer claveAeropuerto, Aeropuerto aeropuerto);

    Optional<Aeropuerto> borrarAeropuerto(int claveAeropuerto);

    void borrarTodosLosAeropuertos();
}
