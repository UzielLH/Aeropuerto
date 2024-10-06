/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public interface PilotoService {

    PilotoModel registrarPiloto(PilotoModel pilotoModel);

    List<PilotoModel> obtenerPilotos();

    Optional<PilotoModel> getPilotos(int id);

    Optional<PilotoModel> actualizarDatosPiloto(PilotoModel pilotoModel, int id);

    Optional<PilotoModel> borrarPiloto(int id);

    void borrarTodosLosPilotos();
}
