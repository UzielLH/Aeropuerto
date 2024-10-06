/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.HelicopteroModel;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface HelicopteroModelService {
    HelicopteroModel registrarHelicoptero(HelicopteroModel helicopteroModel);

    List<HelicopteroModel> obtenerHelicopteros();

    Optional<HelicopteroModel> getHelicoptero(int matricula);

    Optional<HelicopteroModel> actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int matricula);

    Optional<HelicopteroModel> borrarHelicoptero(int matricula);

    void borrarTodosLosHelicopteros();
}
