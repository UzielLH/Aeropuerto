/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos.TerminalDto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos.TripulanteDto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos.VehiculoAereoDto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.dtos.VueloDto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.PasajeroRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.VueloRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AeropuertoService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TerminalModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TripulacionService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VehiculoAereoModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VueloService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.stream.Collectors;

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

    @Autowired
    private AeropuertoService aeropuertoService;

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private EntityManager entityManager;

    // @Transactional
    // @Override
    // public VueloModel registrarVuelo(VueloModel vueloModel) {

    // if (vueloModel.getTripulacionIds() == null) {
    // vueloModel.setTripulacionIds(new ArrayList<>());
    // }

    // List<TripulacionModel> tripulacion = new ArrayList<>();

    // vueloModel.getTripulacionIds().forEach(id -> {
    // Optional<TripulacionModel> tripulacionOptional =
    // tripulacionService.getTripulacion(id);
    // tripulacion.add(tripulacionOptional.orElseThrow());
    // });

    // vueloModel.setTripulacion(tripulacion);

    // vueloModel.setTerminal(terminalModelService.getTerminal(vueloModel.getTerminalId()).orElseThrow());

    // vueloModel.setVehiculoAereo(
    // vehiculoAereoModelService.getVehiculoAereo(vueloModel.getVehiculoAereoId()).orElseThrow());

    // VueloModel vuelo = vueloRepository.save(vueloModel);

    // vueloModel.getTripulacionIds().forEach(t -> {
    // TripulacionModel tripulacionModel =
    // tripulacionService.getTripulacion(t).orElseThrow();
    // tripulacionModel.setVuelo(vuelo);
    // tripulacionService.actualizarDatosTripulacion(tripulacionModel, t);

    // });

    // return getVuelo(vuelo.getIdVuelo()).orElseThrow();
    // }

    @Transactional
    @Override
    public VueloModel registrarVuelo(VueloModel vueloModel) {
        TerminalModel terminal = entityManager.find(TerminalModel.class, vueloModel.getTerminal().getClaveTerminal());
        if (terminal == null) {
            throw new EntityNotFoundException(
                    "No se encontró la terminal con clave " + vueloModel.getTerminal().getClaveTerminal());
        }
        vueloModel.setTerminal(terminal);

        VehiculoAereoModel vehiculoAereo = entityManager.find(VehiculoAereoModel.class,
                vueloModel.getVehiculoAereo().getMatricula());
        if (vehiculoAereo == null) {
            throw new EntityNotFoundException(
                    "No se encontró el vehículo aéreo con matrícula " + vueloModel.getVehiculoAereo().getMatricula());
        }
        vueloModel.setVehiculoAereo(vehiculoAereo);

        List<TripulacionModel> tripulacion = vueloModel.getTripulacion().stream()
                .map(tripulacionModel -> {
                    TripulacionModel foundTripulacion = entityManager.find(TripulacionModel.class,
                            tripulacionModel.getIdTripulacion());
                    if (foundTripulacion == null) {
                        throw new EntityNotFoundException(
                                "No se encontró la tripulación con id " + tripulacionModel.getIdTripulacion());
                    }
                    return foundTripulacion;
                })
                .collect(Collectors.toList());

        vueloModel.setTripulacion(tripulacion);

        VueloModel savedVuelo = vueloRepository.save(vueloModel);

        tripulacion.forEach(tripulacionModel -> {
            tripulacionModel.setVuelo(savedVuelo);
            entityManager.merge(tripulacionModel);
        });

        return savedVuelo;
    }

    @Transactional
    @Override
    public VueloModel save(VueloModel vueloModel) {

        TerminalModel terminal = new TerminalModel();
        terminal.setCapacidad(vueloModel.getTerminal().getCapacidad());
        terminal.setDisponible(vueloModel.getTerminal().isDisponible());
        terminal.setAeropuerto(aeropuertoService.getAeropuerto(1).orElseThrow());
        TerminalModel terminalDb = terminalModelService.registrarTerminal(terminal);
        vueloModel.setTerminal(terminalDb);

        List<TripulacionModel> tripulacion = new ArrayList<>();
        vueloModel.getTripulacionIds().forEach(id -> {
            Optional<TripulacionModel> tripulacionOptional = tripulacionService.getTripulacion(id);
            tripulacion.add(tripulacionOptional.orElseThrow());
        });
        vueloModel.setTripulacion(tripulacion);

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

    @Override
    public List<PasajeroModel> obtenerPasajeros(int id) {
        List<PasajeroModel> pasajeros = pasajeroRepository.findPasajerosByVueloId(id);
        return pasajeros.stream()
                .map(p -> PasajeroModel.builder()
                        .id(p.getId())
                        .nombre(p.getNombre())
                        .apellido(p.getApellido())
                        .direccion(p.getDireccion())
                        .fechaNacimiento(p.getFechaNacimiento())
                        .discapacidad(p.getDiscapacidad())
                        .nacionalidad(p.getNacionalidad())
                        .boletoModel(p.getBoletoModel())
                        .equipajes(p.getEquipajes())
                        .build())

                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> obtenerDetallesVuelo(int id) {
        VueloModel vuelo = vueloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vuelo no encontrado"));

        TerminalDto terminalDto = new TerminalDto(vuelo.getTerminal().getClaveTerminal(),
                vuelo.getTerminal().getCapacidad());

        VehiculoAereoDto vehiculoAereoDto = new VehiculoAereoDto(vuelo.getVehiculoAereo().getMatricula(),
                vuelo.getVehiculoAereo().getModel(), vuelo.getVehiculoAereo().getSerie(),
                vuelo.getVehiculoAereo().getCapacidad(), vuelo.getVehiculoAereo().getEstado(),
                vuelo.getVehiculoAereo().getAntiguedad(), vuelo.getVehiculoAereo().getLlantas(),
                vuelo.getVehiculoAereo().getTanque(), vuelo.getVehiculoAereo().getDistancia());

        List<TripulanteDto> sobrecargos = new ArrayList<>();

        for (TripulacionModel tripulante : vuelo.getTripulacion()) {
            if (tripulante instanceof SobrecargoModel) {
                SobrecargoModel sobrecargo = (SobrecargoModel) tripulante;
                sobrecargos.add(new TripulanteDto(sobrecargo.getIdTripulacion(), sobrecargo.getAntiguedad(),
                        sobrecargo.getTurno(), sobrecargo.getHorasVuelo(), sobrecargo.getNombre(),
                        sobrecargo.getApellido(), sobrecargo.getFechaNac(), sobrecargo.getGenero()));
            }
        }

        TripulanteDto piloto = vuelo.getTripulacion().stream()
                .filter(tripulante -> tripulante instanceof PilotoModel)
                .map(tripulante -> (PilotoModel) tripulante)
                .map(pilotoModel -> new TripulanteDto(pilotoModel.getIdTripulacion(), pilotoModel.getAntiguedad(),
                        pilotoModel.getTurno(), pilotoModel.getHorasVuelo(), pilotoModel.getNombre(),
                        pilotoModel.getApellido(), pilotoModel.getFechaNac(), pilotoModel.getGenero()))
                .findFirst()
                .orElse(null);

        TripulanteDto copiloto = vuelo.getTripulacion().stream()
                .filter(tripulante -> tripulante instanceof CopilotoModel)
                .map(tripulante -> (CopilotoModel) tripulante)
                .map(copilotoModel -> new TripulanteDto(copilotoModel.getIdTripulacion(), copilotoModel.getAntiguedad(),
                        copilotoModel.getTurno(), copilotoModel.getHorasVuelo(), copilotoModel.getNombre(),
                        copilotoModel.getApellido(), copilotoModel.getFechaNac(), copilotoModel.getGenero()))
                .findFirst()
                .orElse(null);

        VueloDto vueloDto = VueloDto.builder()
                .idVuelo(vuelo.getIdVuelo())
                .origen(vuelo.getOrigen())
                .destino(vuelo.getDestino())
                .duracion(vuelo.getDuracion())
                .horaSalida(vuelo.getHoraSalida())
                .horaLlegada(vuelo.getHoraLlegada())
                .terminal(terminalDto)
                .datosAvion(vehiculoAereoDto)
                .piloto(piloto)
                .copiloto(copiloto)
                .sobrecargos(sobrecargos)
                .build();

        return Map.of("vuelo", vueloDto);
    }

}
