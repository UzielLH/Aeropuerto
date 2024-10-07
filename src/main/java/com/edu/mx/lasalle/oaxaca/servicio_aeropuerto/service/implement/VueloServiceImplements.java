/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.VueloRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TerminalModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TripulacionService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VehiculoAereoModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VueloService;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    private TripulacionService tripulacionService;

    @Autowired
    private TerminalModelService terminalModelService;

    @Autowired
    private VehiculoAereoModelService vehiculoAereoModelService;

    @Transactional
    @Override
    public VueloModel registrarVuelo(VueloModel vueloModel) {

        if (vueloModel.getTripulacionIds() == null) {
            vueloModel.setTripulacionIds(new ArrayList<>());
        }

        List<TripulacionModel> tripulacion = new ArrayList<>();

        vueloModel.getTripulacionIds().forEach(id -> {
            Optional<TripulacionModel> tripulacionOptional = tripulacionService.getTripulacion(id);
            tripulacion.add(tripulacionOptional.orElseThrow());
        });

        vueloModel.setTripulacion(tripulacion);

        vueloModel.setTerminal(terminalModelService.getTerminal(vueloModel.getTerminalId()).orElseThrow());

        vueloModel.setVehiculoAereo(
                vehiculoAereoModelService.getVehiculoAereo(vueloModel.getVehiculoAereoId()).orElseThrow());

        VueloModel vuelo = vueloRepository.save(vueloModel);

        vueloModel.getTripulacionIds().forEach(t -> {
            TripulacionModel tripulacionModel = tripulacionService.getTripulacion(t).orElseThrow();
            tripulacionModel.setVuelo(vuelo);
            tripulacionService.actualizarDatosTripulacion(tripulacionModel, t);

        });

        return getVuelo(vuelo.getIdVuelo()).orElseThrow();
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
            VueloModel vueloActualizado = vueloOptional.get();

            // Actualiza los atributos del vuelo
            vueloActualizado.setOrigen(vueloModel.getOrigen());
            vueloActualizado.setDestino(vueloModel.getDestino());
            vueloActualizado.setDuracion(vueloModel.getDuracion());
            vueloActualizado.setHoraLlegada(vueloModel.getHoraLlegada());
            vueloActualizado.setHoraSalida(vueloModel.getHoraSalida());

            // Actualiza la terminal
            vueloActualizado.setTerminal(terminalModelService.getTerminal(vueloModel.getTerminalId()).orElseThrow());

            // Actualiza el vehículo aéreo
            vueloActualizado.setVehiculoAereo(
                    vehiculoAereoModelService.getVehiculoAereo(vueloModel.getVehiculoAereoId()).orElseThrow());

            // Manejo de boletos
            if (vueloModel.getBoletos() != null) {
                vueloActualizado.getBoletos().clear(); // Mantiene la colección de boletos
                vueloActualizado.getBoletos().addAll(vueloModel.getBoletos());
            }

            // Manejo de tripulación
            if (vueloModel.getTripulacionIds() != null) {
                List<TripulacionModel> nuevaTripulacion = new ArrayList<>();
                for (Integer idTripulacion : vueloModel.getTripulacionIds()) {
                    TripulacionModel tripulacionModel = tripulacionService.getTripulacion(idTripulacion).orElseThrow();
                    tripulacionModel.setVuelo(vueloActualizado); // Establece la referencia del vuelo
                    nuevaTripulacion.add(tripulacionModel);
                }
                vueloActualizado.getTripulacion().clear();
                vueloActualizado.getTripulacion().addAll(nuevaTripulacion); // Establece la nueva tripulación
            }

            // Guarda y retorna el vuelo actualizado
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
