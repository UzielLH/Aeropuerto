/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.HelicopteroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.HelicopteroModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.HelicopteroModelService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ferrc
 */
@Service
public class HelicopteroModelServiceImplements implements HelicopteroModelService {

    @Autowired
    private HelicopteroModelRepository helicopteroModelRepository;

    @Transactional
    @Override
    public HelicopteroModel registrarHelicoptero(HelicopteroModel helicopteroModel) {
        return helicopteroModelRepository.save(helicopteroModel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HelicopteroModel> obtenerHelicopteros() {
        return (List<HelicopteroModel>) helicopteroModelRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<HelicopteroModel> getHelicoptero(int matricula) {
        return helicopteroModelRepository.findByMatricula(matricula);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<HelicopteroModel> actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int matricula) {
        Optional<HelicopteroModel> helicopteroOptional = helicopteroModelRepository.findByMatricula(matricula);
        if (helicopteroOptional.isPresent()) {
            HelicopteroModel helicopteroActualizado = helicopteroOptional.orElseThrow();
            helicopteroActualizado.setModel(helicopteroModel.getModel());
            helicopteroActualizado.setSerie(helicopteroModel.getSerie());
            helicopteroActualizado.setCapacidad(helicopteroModel.getCapacidad());
            helicopteroActualizado.setColor(helicopteroModel.getColor());
            helicopteroActualizado.setEstado(helicopteroModel.getEstado());
            helicopteroActualizado.setAntiguedad(helicopteroModel.getAntiguedad());
            helicopteroActualizado.setLlantas(helicopteroModel.getLlantas());
            helicopteroActualizado.setTanque(helicopteroModel.getTanque());
            helicopteroActualizado.setDistancia(helicopteroModel.getDistancia());
            helicopteroActualizado.setHelices(helicopteroModel.getHelices());
            helicopteroActualizado.setTipo(helicopteroModel.getTipo());
            return Optional.of(helicopteroModelRepository.save(helicopteroActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<HelicopteroModel> borrarHelicoptero(int matricula) {
        Optional<HelicopteroModel> helicopteroOptional = helicopteroModelRepository.findByMatricula(matricula);
        if (helicopteroOptional.isPresent()) {
            helicopteroModelRepository.delete(helicopteroOptional.orElseThrow());
            return helicopteroOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosHelicopteros() {
        helicopteroModelRepository.deleteAll();
    }

}
