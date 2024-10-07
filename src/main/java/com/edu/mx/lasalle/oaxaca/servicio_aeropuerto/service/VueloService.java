/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import java.util.*;

/**
 *
 * @author tokay
 */
public interface VueloService {
    VueloModel registrarVuelo(VueloModel vueloModel);

    List<VueloModel> obtenerVuelo();

    Optional<VueloModel> getVuelo(int id);

    Optional<VueloModel> actualizarDatosVuelo(VueloModel vueloModel, int id);

    Optional<VueloModel> borrarVuelo(int id);

    void borrarTodosVuelo();
}
