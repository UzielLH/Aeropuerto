/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.AvionModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AvionModelService;
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
public class AvionModelServiceImplements implements AvionModelService {

    @Autowired
    private AvionModelRepository avionModelRepository;

    @Override
    @Transactional
    public AvionModel registrarAvion(AvionModel avionModel) {
        return avionModelRepository.save(avionModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AvionModel> obtenerAviones() {
        return (List<AvionModel>) avionModelRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AvionModel> getAvion(int matricula) {
        return avionModelRepository.findByMatricula(matricula);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<AvionModel> actualizarDatosAvion(AvionModel avionModel, int matricula) {
        Optional<AvionModel> avionModelOptional = avionModelRepository.findByMatricula(matricula);
        if (avionModelOptional.isPresent()) {
            AvionModel avionModelActualizado = avionModelOptional.orElseThrow();
            avionModelActualizado.setModel(avionModel.getModel());
            avionModelActualizado.setSerie(avionModel.getSerie());
            avionModelActualizado.setCapacidad(avionModel.getCapacidad());
            avionModelActualizado.setColor(avionModel.getColor());
            avionModelActualizado.setEstado(avionModel.getEstado());
            avionModelActualizado.setAntiguedad(avionModel.getAntiguedad());
            avionModelActualizado.setLlantas(avionModel.getLlantas());
            avionModelActualizado.setTanque(avionModel.getTanque());
            avionModelActualizado.setDistancia(avionModel.getDistancia());
            avionModelActualizado.setAerolinea(avionModel.getAerolinea());
            avionModelActualizado.setTipoMotor(avionModel.getTipoMotor());
            avionModelActualizado.setPuertas(avionModel.getPuertas());
            avionModelActualizado.setTipo(avionModel.getTipo());
            return Optional.of(avionModelRepository.save(avionModelActualizado));
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Modifying
    @Override
    public Optional<AvionModel> borrarAvion(int matricula) {
        Optional<AvionModel> avionModelOptional = avionModelRepository.findByMatricula(matricula);
        if (avionModelOptional.isPresent()) {
            avionModelRepository.delete(avionModelOptional.orElseThrow());
            return avionModelOptional;
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosAviones() {
        avionModelRepository.deleteAll();
    }

}
