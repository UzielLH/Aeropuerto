/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public interface BoletoService {
    public void registrarBoleto(BoletoModel boletoModel);
    public List<BoletoModel> obtenerBoletos();
    public BoletoModel getBoleto(int id);
    public void actualizarDatosBoleto(BoletoModel boletoModel, int id);
    public void borrarBoleto(int id);
    public void borrarTodosLosBoletos();
}
