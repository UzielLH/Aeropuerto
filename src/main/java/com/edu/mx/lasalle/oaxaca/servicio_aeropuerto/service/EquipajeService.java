package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface EquipajeService {
    EquipajeModel registrarEquipaje(EquipajeModel equipajeModel);

    List<EquipajeModel> obtenerEquipajes();

    Optional<EquipajeModel> getEquipaje(int id);

    Optional<EquipajeModel> actualizarDatosEquipaje(EquipajeModel equipajeModel, int id);

    Optional<EquipajeModel> borrarEquipaje(int id);

    void borrarTodosLosEquipajes();
}
