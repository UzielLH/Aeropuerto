/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.TripulacionRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TripulacionService;
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
public class TripulacionServiceImplements implements TripulacionService {
    @Autowired
    private TripulacionRepository tripulacionRepository;

    @Transactional
    @Override
    public TripulacionModel registrarTripulacion(TripulacionModel tripulacionModel) {
        return tripulacionRepository.save(tripulacionModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TripulacionModel> obtenerTripulacion() {
        return (List<TripulacionModel>) tripulacionRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<TripulacionModel> getTripulacion(int id) {
        return tripulacionRepository.findById(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<TripulacionModel> actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id) {
        Optional<TripulacionModel> tripulacionOptional = tripulacionRepository.findById(id);
        if (tripulacionOptional.isPresent()) {
            TripulacionModel tripulacionActualizado = tripulacionOptional.orElseThrow();
            tripulacionActualizado.setAntiguedad(tripulacionModel.getAntiguedad());
            tripulacionActualizado.setTurno(tripulacionModel.getTurno());
            tripulacionActualizado.setHorasVuelo(tripulacionModel.getHorasVuelo());
            tripulacionActualizado.setNombre(tripulacionModel.getNombre());
            tripulacionActualizado.setApellido(tripulacionModel.getApellido());
            tripulacionActualizado.setFechaNac(tripulacionModel.getFechaNac());
            tripulacionActualizado.setGenero(tripulacionModel.getGenero());
            return Optional.of(tripulacionRepository.save(tripulacionActualizado));
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Modifying
    @Override
    public Optional<TripulacionModel> borrarTripulacion(int id) {
        Optional<TripulacionModel> tripulacionOptional = tripulacionRepository.findById(id);
        if (tripulacionOptional.isPresent()) {
            tripulacionRepository.delete(tripulacionOptional.orElseThrow());
            return tripulacionOptional;
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosTripulacion() {
        tripulacionRepository.deleteAll();
    }

}
