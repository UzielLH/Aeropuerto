/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.VueloRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VueloService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tokay
 */
@Service
public class VueloServiceImplements implements VueloService {
    @Autowired
    private VueloRepository vueloRepository;

    @Transactional
    @Override
    public VueloModel registrarVuelo(VueloModel vueloModel) {
        return vueloRepository.save(vueloModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VueloModel> obtenerVuelo() {
        return (List<VueloModel>) vueloRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<VueloModel> getVuelo(int id) {
        return vueloRepository.findByIdVuelo(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<VueloModel> actualizarDatosVuelo(VueloModel vueloModel, int id) {
        Optional<VueloModel> vueloOptional = vueloRepository.findByIdVuelo(id);
        if (vueloOptional.isPresent()) {
            VueloModel vueloActualizado = vueloOptional.orElseThrow();
            vueloActualizado.setOrigen(vueloModel.getOrigen());
            vueloActualizado.setDestino(vueloModel.getDestino());
            vueloActualizado.setDuracion(vueloModel.getDuracion());
            vueloActualizado.setHoraLlegada(vueloModel.getHoraLlegada());
            vueloActualizado.setHoraSalida(vueloModel.getHoraSalida());
            vueloActualizado.setTerminal(vueloModel.getTerminal());
            vueloActualizado.setTripulacion(vueloModel.getTripulacion());
            vueloActualizado.setBoletos(vueloModel.getBoletos());
            vueloActualizado.setVehiculoAereo(vueloModel.getVehiculoAereo());
            return Optional.of(vueloRepository.save(vueloActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<VueloModel> borrarVuelo(int id) {
        Optional<VueloModel> vueloOptional = vueloRepository.findByIdVuelo(id);
        if (vueloOptional.isPresent()) {
            vueloRepository.delete(vueloOptional.orElseThrow());
            return vueloOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosVuelo() {
        vueloRepository.deleteAll();
    }

}
