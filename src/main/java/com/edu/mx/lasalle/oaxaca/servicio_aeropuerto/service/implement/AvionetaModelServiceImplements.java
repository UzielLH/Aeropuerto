/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionetaModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.AvionetaModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AvionetaModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ferrc
 */
public class AvionetaModelServiceImplements implements AvionetaModelService {
    
    @Autowired
    private AvionetaModelRepository avionetaModelRepository;

    @Override
    public void registrarAvioneta(AvionetaModel avionetaModel) {
        avionetaModelRepository.save(avionetaModel);
    }

    @Override
    public List<AvionetaModel> obtenerAvionetas() {
        return (List<AvionetaModel>) avionetaModelRepository.findAll();
    }

    @Override
    public AvionetaModel getAvioneta(int matricula) {
        return avionetaModelRepository.findByMatricula(matricula);
    }

    @Override
    public void actualizarDatosAvioneta(AvionetaModel avionetaModel, int matricula) {
        avionetaModel.setMatricula(matricula);
        avionetaModelRepository.save(avionetaModel);
    }

    @Override
    public void borrarAvioneta(int matricula) {
        avionetaModelRepository.deleteById(matricula);
    }

    @Override
    public void borrarTodosLasAvionetas() {
        avionetaModelRepository.deleteAll();
    }
}
