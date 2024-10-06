/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.VehiculoAereoModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VehiculoAereoModelService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ferrc
 */
public class VehiculoAereoModelServiceImplements implements VehiculoAereoModelService {

    @Autowired
    private VehiculoAereoModelRepository vehiculoAereoModelRepository;

    @Transactional
    @Override
    public VehiculoAereoModel registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel) {
        return vehiculoAereoModelRepository.save(vehiculoAereoModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VehiculoAereoModel> obtenerVehiculosAereos() {
        return (List<VehiculoAereoModel>) vehiculoAereoModelRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<VehiculoAereoModel> getVehiculoAereo(int matricula) {
        return vehiculoAereoModelRepository.findByMatricula(matricula);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<VehiculoAereoModel> actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel,
            int matricula) {
        Optional<VehiculoAereoModel> vehiculoAereoOptional = vehiculoAereoModelRepository.findByMatricula(matricula);
        if (vehiculoAereoOptional.isPresent()) {
            VehiculoAereoModel vehiculoAereoActualizado = vehiculoAereoOptional.orElseThrow();
            vehiculoAereoActualizado.setModel(vehiculoAereoModel.getModel());
            vehiculoAereoActualizado.setSerie(vehiculoAereoModel.getSerie());
            vehiculoAereoActualizado.setCapacidad(vehiculoAereoModel.getCapacidad());
            vehiculoAereoActualizado.setColor(vehiculoAereoModel.getColor());
            vehiculoAereoActualizado.setEstado(vehiculoAereoModel.getEstado());
            vehiculoAereoActualizado.setAntiguedad(vehiculoAereoModel.getAntiguedad());
            vehiculoAereoActualizado.setLlantas(vehiculoAereoModel.getLlantas());
            vehiculoAereoActualizado.setTanque(vehiculoAereoModel.getTanque());
            vehiculoAereoActualizado.setDistancia(vehiculoAereoModel.getDistancia());
            return Optional.of(vehiculoAereoModelRepository.save(vehiculoAereoActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<VehiculoAereoModel> borrarVehiculoAereo(int matricula) {
        Optional<VehiculoAereoModel> vehiculoAereoOptional = vehiculoAereoModelRepository.findByMatricula(matricula);
        if (vehiculoAereoOptional.isPresent()) {
            vehiculoAereoModelRepository.delete(vehiculoAereoOptional.orElseThrow());
            return vehiculoAereoOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosVehiculosAereos() {
        vehiculoAereoModelRepository.deleteAll();
    }

}
