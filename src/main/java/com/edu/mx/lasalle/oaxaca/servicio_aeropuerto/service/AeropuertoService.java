/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Aeropuerto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface AeropuertoService {
    public void registrarAeropuerto(Aeropuerto aeropuerto);
    public List<Aeropuerto> obtenerAeropuertos();
    public Aeropuerto getAeropuerto(int claveAeropuerto);
    public void actualizarDatosAeropuerto(Aeropuerto aeropuerto, int claveAeropuerto);
    public void borrarAeropuerto(int claveAeropuerto);
    public void borrarTodosLosAeropuertos();
}
