/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tokay
 */
public interface BoletoService {
    BoletoModel registrarBoleto(BoletoModel boletoModel);

    List<BoletoModel> obtenerBoletos();

    Optional<BoletoModel> getBoleto(int id);

    Optional<BoletoModel> actualizarDatosBoleto(BoletoModel boletoModel, int id);

    Optional<BoletoModel> borrarBoleto(int id);

    void borrarTodosLosBoletos();
}
