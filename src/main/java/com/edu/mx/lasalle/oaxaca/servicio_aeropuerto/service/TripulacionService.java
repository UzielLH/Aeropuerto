/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import java.util.List;

/**
 *
 * @author tokay
 */
public interface TripulacionService {
    public void registrarTripulacion(TripulacionModel tripulacionModel);
    public List<TripulacionModel> obtenerTripulacion();
    public TripulacionModel getTripulacion(int id);
    public void actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id);
    public void borrarTripulacion(int id);
    public void borrarTodosTripulacion();
}
