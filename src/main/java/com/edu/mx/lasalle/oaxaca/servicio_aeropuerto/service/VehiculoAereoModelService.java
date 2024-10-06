/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface VehiculoAereoModelService {
    VehiculoAereoModel registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel);

    List<VehiculoAereoModel> obtenerVehiculosAereos();

    Optional<VehiculoAereoModel> getVehiculoAereo(int matricula);

    Optional<VehiculoAereoModel> actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel, int matricula);

    Optional<VehiculoAereoModel> borrarVehiculoAereo(int matricula);

    void borrarTodosLosVehiculosAereos();
}
