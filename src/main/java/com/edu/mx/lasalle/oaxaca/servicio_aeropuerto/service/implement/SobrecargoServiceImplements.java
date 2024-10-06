/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.SobrecargoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.SobrecargoService;
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
public class SobrecargoServiceImplements implements SobrecargoService {
    @Autowired
    private SobrecargoRepository sobrecargoRepository;

    @Transactional
    @Override
    public SobrecargoModel registrarSobrecargo(SobrecargoModel sobrecargoModel) {
        return sobrecargoRepository.save(sobrecargoModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SobrecargoModel> obtenerSobrecargos() {
        return (List<SobrecargoModel>) sobrecargoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SobrecargoModel> getSobrecargos(int id) {
        return sobrecargoRepository.findByIdTripulacion(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<SobrecargoModel> actualizarDatosSobrecargo(SobrecargoModel sobrecargoModel, int id) {
        Optional<SobrecargoModel> sobrecargoOptional = sobrecargoRepository.findByIdTripulacion(id);
        if (sobrecargoOptional.isPresent()) {
            SobrecargoModel sobrecargoActualizado = sobrecargoOptional.orElseThrow();
            sobrecargoActualizado.setAntiguedad(sobrecargoModel.getAntiguedad());
            sobrecargoActualizado.setTurno(sobrecargoModel.getTurno());
            sobrecargoActualizado.setHorasVuelo(sobrecargoModel.getHorasVuelo());
            sobrecargoActualizado.setNombre(sobrecargoModel.getNombre());
            sobrecargoActualizado.setApellido(sobrecargoModel.getApellido());
            sobrecargoActualizado.setFechaNac(sobrecargoModel.getFechaNac());
            sobrecargoActualizado.setGenero(sobrecargoModel.getGenero());
            sobrecargoActualizado.setIdiomas(sobrecargoModel.getIdiomas());
            sobrecargoActualizado.setCertificados(sobrecargoModel.getCertificados());
            return Optional.of(sobrecargoRepository.save(sobrecargoActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<SobrecargoModel> borrarCopiloto(int id) {
        Optional<SobrecargoModel> sobrecargoOptional = sobrecargoRepository.findByIdTripulacion(id);
        if (sobrecargoOptional.isPresent()) {
            sobrecargoRepository.delete(sobrecargoOptional.orElseThrow());
            return sobrecargoOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosCopilotos() {
        sobrecargoRepository.deleteAll();
    }

}
