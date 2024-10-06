/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.PilotoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PilotoService;
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
public class PilotoServiceImplements implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    @Transactional
    @Override
    public PilotoModel registrarPiloto(PilotoModel pilotoModel) {
        return pilotoRepository.save(pilotoModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PilotoModel> obtenerPilotos() {
        return (List<PilotoModel>) pilotoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PilotoModel> getPilotos(int id) {
        return pilotoRepository.findByIdTripulacion(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<PilotoModel> actualizarDatosPiloto(PilotoModel pilotoModel, int id) {
        Optional<PilotoModel> pilotoOptional = pilotoRepository.findByIdTripulacion(id);
        if (pilotoOptional.isPresent()) {
            PilotoModel pilotoActualizado = pilotoOptional.orElseThrow();
            pilotoActualizado.setAntiguedad(pilotoModel.getAntiguedad());
            pilotoActualizado.setTurno(pilotoModel.getTurno());
            pilotoActualizado.setHorasVuelo(pilotoModel.getHorasVuelo());
            pilotoActualizado.setNombre(pilotoModel.getNombre());
            pilotoActualizado.setApellido(pilotoModel.getApellido());
            pilotoActualizado.setFechaNac(pilotoModel.getFechaNac());
            pilotoActualizado.setGenero(pilotoModel.getGenero());
            pilotoActualizado.setRango(pilotoModel.getRango());
            pilotoActualizado.setLicencia(pilotoModel.getLicencia());
            pilotoActualizado.setTipoAeronaves(pilotoModel.getTipoAeronaves());
            pilotoActualizado.setSaludMental(pilotoModel.getSaludMental());
            return Optional.of(pilotoRepository.save(pilotoActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<PilotoModel> borrarPiloto(int id) {
        Optional<PilotoModel> pilotoOptional = pilotoRepository.findByIdTripulacion(id);
        if (pilotoOptional.isPresent()) {
            pilotoRepository.delete(pilotoOptional.orElseThrow());
            return pilotoOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosPilotos() {
        pilotoRepository.deleteAll();
    }

}
