/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionModel;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ferrc
 */
public interface AvionModelService {
    AvionModel registrarAvion(AvionModel avionModel);

    List<AvionModel> obtenerAviones();

    Optional<AvionModel> getAvion(int matricula);

    Optional<AvionModel> actualizarDatosAvion(AvionModel avionModel, int matricula);

    Optional<AvionModel> borrarAvion(int matricula);

    void borrarTodosLosAviones();
}
