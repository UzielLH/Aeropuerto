/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.HelicopteroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.HelicopteroModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.HelicopteroModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ferrc
 */
public class HelicopteroModelServiceImplements implements HelicopteroModelService {
    
    @Autowired
    private HelicopteroModelRepository helicopteroModelRepository;

    @Override
    public void registrarHelicoptero(HelicopteroModel helicopteroModel) {
        helicopteroModelRepository.save(helicopteroModel);
    }

    @Override
    public List<HelicopteroModel> obtenerHelicopteros() {
        return (List<HelicopteroModel>) helicopteroModelRepository.findAll();
    }

    @Override
    public HelicopteroModel getHelicoptero(int matricula) {
        return helicopteroModelRepository.findByMatricula(matricula);
    }

    @Override
    public void actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int matricula) {
        helicopteroModel.setMatricula(matricula);
        helicopteroModelRepository.save(helicopteroModel);
    }

    @Override
    public void borrarHelicoptero(int matricula) {
        helicopteroModelRepository.deleteById(matricula);
    }

    @Override
    public void borrarTodosLosHelicopteros() {
        helicopteroModelRepository.deleteAll();
    }
}
