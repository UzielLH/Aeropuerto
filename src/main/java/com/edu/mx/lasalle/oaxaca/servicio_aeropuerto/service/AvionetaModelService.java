/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionetaModel;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface AvionetaModelService {
    AvionetaModel registrarAvioneta(AvionetaModel avionetaModel);

    List<AvionetaModel> obtenerAvionetas();

    Optional<AvionetaModel> getAvioneta(int matricula);

    Optional<AvionetaModel> actualizarDatosAvioneta(AvionetaModel avionetaModel, int matricula);

    Optional<AvionetaModel> borrarAvioneta(int matricula);

    void borrarTodosLasAvionetas();
}
