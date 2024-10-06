/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Aeropuerto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.AeropuertoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AeropuertoService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ferrc
 */
public class AeropuertoServiceImplements implements AeropuertoService {

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @Transactional
    @Override
    public Aeropuerto registrarAeropuerto(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(aeropuerto);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aeropuerto> obtenerAeropuertos() {
        return (List<Aeropuerto>) aeropuertoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Aeropuerto> getAeropuerto(int claveAeropuerto) {
        return aeropuertoRepository.findByClaveAeropuerto(claveAeropuerto);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<Aeropuerto> actualizarDatosAeropuerto(Integer claveAeropuerto, Aeropuerto aeropuerto) {
        Optional<Aeropuerto> aeropuertoOptional = aeropuertoRepository.findByClaveAeropuerto(claveAeropuerto);
        if (aeropuertoOptional.isPresent()) {
            Aeropuerto aeropuertoActualizado = aeropuertoOptional.orElseThrow();
            aeropuertoActualizado.setNombre(aeropuerto.getNombre());
            aeropuertoActualizado.setNumeroPistas(aeropuerto.getNumeroPistas());
            aeropuertoActualizado.setTerminal(aeropuerto.getTerminal());

            return Optional.of(aeropuertoRepository.save(aeropuertoActualizado));
        }

        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<Aeropuerto> borrarAeropuerto(int claveAeropuerto) {
        Optional<Aeropuerto> aeropuertoOptional = aeropuertoRepository.findByClaveAeropuerto(claveAeropuerto);
        if (aeropuertoOptional.isPresent()) {
            aeropuertoRepository.delete(aeropuertoOptional.orElseThrow());
            return aeropuertoOptional;
        }

        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosAeropuertos() {
        aeropuertoRepository.deleteAll();
    }

}
