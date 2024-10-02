/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import java.util.List;

/**
 *
 * @author tokay
 */
public interface CopilotoService {
    public void registrarCopiloto(CopilotoModel copilotoModel);
    public List<CopilotoModel> obtenerCopilotos();
    public CopilotoModel getCopiloto(int id);
    public void actualizarDatosCopiloto(CopilotoModel copilotoModel, int id);
    public void borrarCopiloto(int id);
    public void borrarTodosLosCopilotos();
}
