/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionetaModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface AvionetaModelService {
    public void registrarAvioneta(AvionetaModel avionetaModel);
    public List<AvionetaModel> obtenerAvionetas();
    public AvionetaModel getAvioneta(int matricula);
    public void actualizarDatosAvioneta(AvionetaModel avionetaModel, int matricula);
    public void borrarAvioneta(int matricula);
    public void borrarTodosLasAvionetas();
}
