/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public interface VueloService {
    public void registrarVuelo(VueloModel vueloModel);
    public List<VueloModel> obtenerVuelo();
    public VueloModel getVuelo(int id);
    public void actualizarDatosVuelo(VueloModel vueloModel, int id);
    public void borrarVuelo(int id);
    public void borrarTodosVuelo();
}
