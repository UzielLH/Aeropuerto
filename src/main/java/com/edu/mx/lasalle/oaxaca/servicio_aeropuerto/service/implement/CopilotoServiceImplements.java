/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.CopilotoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.CopilotoService;
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
public class CopilotoServiceImplements implements CopilotoService {
    @Autowired
    private CopilotoRepository copilotoRepository;

    @Transactional
    @Override
    public CopilotoModel registrarCopiloto(CopilotoModel copilotoModel) {
        return copilotoRepository.save(copilotoModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CopilotoModel> obtenerCopilotos() {
        return (List<CopilotoModel>) copilotoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CopilotoModel> getCopiloto(int id) {
        return copilotoRepository.findByIdTripulacion(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<CopilotoModel> actualizarDatosCopiloto(CopilotoModel copilotoModel, int id) {
        Optional<CopilotoModel> copilotoOptional = copilotoRepository.findById(id);
        if (copilotoOptional.isPresent()) {
            CopilotoModel copilotoActualizado = copilotoOptional.orElseThrow();
            copilotoActualizado.setAntiguedad(copilotoModel.getAntiguedad());
            copilotoActualizado.setTurno(copilotoModel.getTurno());
            copilotoActualizado.setHorasVuelo(copilotoModel.getHorasVuelo());
            copilotoActualizado.setNombre(copilotoModel.getNombre());
            copilotoActualizado.setApellido(copilotoModel.getApellido());
            copilotoActualizado.setFechaNac(copilotoModel.getFechaNac());
            copilotoActualizado.setGenero(copilotoModel.getGenero());
            copilotoActualizado.setRango(copilotoModel.getRango());
            copilotoActualizado.setTiempoRestantePiloto(copilotoModel.getTiempoRestantePiloto());
            return Optional.of(copilotoRepository.save(copilotoActualizado));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    @Modifying
    public Optional<CopilotoModel> borrarCopiloto(int id) {
        Optional<CopilotoModel> copilotoOptional = copilotoRepository.findById(id);
        if (copilotoOptional.isPresent()) {
            copilotoRepository.deleteById(id);
            return copilotoOptional;
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    @Modifying
    public void borrarTodosLosCopilotos() {
        copilotoRepository.deleteAll();
    }

}
