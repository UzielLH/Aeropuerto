/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionetaModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.AvionetaModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AvionetaModelService;
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
public class AvionetaModelServiceImplements implements AvionetaModelService {

    @Autowired
    private AvionetaModelRepository avionetaModelRepository;

    @Override
    @Transactional
    public AvionetaModel registrarAvioneta(AvionetaModel avionetaModel) {
        return avionetaModelRepository.save(avionetaModel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AvionetaModel> obtenerAvionetas() {
        return (List<AvionetaModel>) avionetaModelRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AvionetaModel> getAvioneta(int matricula) {
        return avionetaModelRepository.findByMatricula(matricula);
    }

    @Override
    @Transactional
    @Modifying
    public Optional<AvionetaModel> actualizarDatosAvioneta(AvionetaModel avionetaModel, int matricula) {
        Optional<AvionetaModel> avionetaOptional = avionetaModelRepository.findByMatricula(matricula);
        if (avionetaOptional.isPresent()) {
            AvionetaModel avionetaActualizado = avionetaOptional.orElseThrow();
            avionetaActualizado.setModel(avionetaModel.getModel());
            avionetaActualizado.setSerie(avionetaModel.getSerie());
            avionetaActualizado.setCapacidad(avionetaModel.getCapacidad());
            avionetaActualizado.setColor(avionetaModel.getColor());
            avionetaActualizado.setEstado(avionetaModel.getEstado());
            avionetaActualizado.setAntiguedad(avionetaModel.getAntiguedad());
            avionetaActualizado.setLlantas(avionetaModel.getLlantas());
            avionetaActualizado.setTanque(avionetaModel.getTanque());
            avionetaActualizado.setDistancia(avionetaModel.getDistancia());
            avionetaActualizado.setNumeroMotores(avionetaModel.getNumeroMotores());
            avionetaActualizado.setTipoPista(avionetaModel.getTipoPista());
            avionetaActualizado.setClasificacion(avionetaModel.getClasificacion());
            avionetaActualizado.setTipoCombustion(avionetaModel.getTipoCombustion());

            return Optional.of(avionetaModelRepository.save(avionetaActualizado));
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    @Modifying
    public Optional<AvionetaModel> borrarAvioneta(int matricula) {
        Optional<AvionetaModel> avionetaOptional = avionetaModelRepository.findByMatricula(matricula);
        if (avionetaOptional.isPresent()) {
            avionetaModelRepository.delete(avionetaOptional.orElseThrow());
            return avionetaOptional;
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    @Modifying
    public void borrarTodosLasAvionetas() {
        avionetaModelRepository.deleteAll();
    }

}
