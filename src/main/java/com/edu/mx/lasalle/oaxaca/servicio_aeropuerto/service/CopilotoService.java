/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tokay
 */
public interface CopilotoService {
    CopilotoModel registrarCopiloto(CopilotoModel copilotoModel);

    List<CopilotoModel> obtenerCopilotos();

    Optional<CopilotoModel> getCopiloto(int id);

    Optional<CopilotoModel> actualizarDatosCopiloto(CopilotoModel copilotoModel, int id);

    Optional<CopilotoModel> borrarCopiloto(int id);

    void borrarTodosLosCopilotos();
}
