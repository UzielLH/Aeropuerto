/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public interface PilotoService {
    public void registrarPiloto(PilotoModel pilotoModel);
    public List<PilotoModel> obtenerPilotos();
    public PilotoModel getPilotos(int id);
    public void actualizarDatosPiloto(PilotoModel pilotoModel, int id);
    public void borrarPiloto(int id);
    public void borrarTodosLosPilotos();
}
