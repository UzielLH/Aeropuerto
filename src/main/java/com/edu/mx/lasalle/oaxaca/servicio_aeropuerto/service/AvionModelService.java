/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface AvionModelService {
    public void registrarAvion(AvionModel avionModel);
    public List<AvionModel> obtenerAviones();
    public AvionModel getAvion(int matricula);
    public void actualizarDatosAvion(AvionModel avionModel, int matricula);
    public void borrarAvion(int matricula);
    public void borrarTodosLosAviones();
}
