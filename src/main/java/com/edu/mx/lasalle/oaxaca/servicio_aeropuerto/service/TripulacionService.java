/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import java.util.*;

/**
 *
 * @author tokay
 */
public interface TripulacionService {
    TripulacionModel registrarTripulacion(TripulacionModel tripulacionModel);

    List<TripulacionModel> obtenerTripulacion();

    Optional<TripulacionModel> getTripulacion(int id);

    Optional<TripulacionModel> actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id);

    Optional<TripulacionModel> borrarTripulacion(int id);

    void borrarTodosTripulacion();
}
