/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public interface SobrecargoService {
    public void registrarSobrecargo(SobrecargoModel sobrecargoModel);
    public List<SobrecargoModel> obtenerSobrecargos();
    public SobrecargoModel getSobrecargos(int id);
    public void actualizarDatosSobrecargo(SobrecargoModel sobrecargoModel, int id);
    public void borrarCopiloto(int id);
    public void borrarTodosLosCopilotos();
}
