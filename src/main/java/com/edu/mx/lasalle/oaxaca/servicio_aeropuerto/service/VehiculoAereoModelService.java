/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface VehiculoAereoModelService {
    public void registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel);
    public List<VehiculoAereoModel> obtenerVehiculosAereos();
    public VehiculoAereoModel getVehiculoAereo(int matricula);
    public void actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel, int matricula);
    public void borrarVehiculoAereo(int matricula);
    public void borrarTodosLosVehiculosAereos();
}
