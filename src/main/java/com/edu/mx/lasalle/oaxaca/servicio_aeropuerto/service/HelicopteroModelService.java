/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.HelicopteroModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface HelicopteroModelService {
    public void registrarHelicoptero(HelicopteroModel helicopteroModel);
    public List<HelicopteroModel> obtenerHelicopteros();
    public HelicopteroModel getHelicoptero(int matricula);
    public void actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int matricula);
    public void borrarHelicoptero(int matricula);
    public void borrarTodosLosHelicopteros();
}
