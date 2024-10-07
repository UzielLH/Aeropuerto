/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import java.util.*;

/**
 *
 * @author tokay
 */
public interface SobrecargoService {
    SobrecargoModel registrarSobrecargo(SobrecargoModel sobrecargoModel);

    List<SobrecargoModel> obtenerSobrecargos();

    Optional<SobrecargoModel> getSobrecargos(int id);

    Optional<SobrecargoModel> actualizarDatosSobrecargo(SobrecargoModel sobrecargoModel, int id);

    Optional<SobrecargoModel> borrarCopiloto(int id);

    void borrarTodosLosCopilotos();
}
