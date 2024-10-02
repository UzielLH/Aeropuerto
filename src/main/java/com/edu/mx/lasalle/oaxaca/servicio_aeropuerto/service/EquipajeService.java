package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EquipajeService {
    public void registrarEquipaje(EquipajeModel equipajeModel);

    public List<EquipajeModel> obtenerEquipajes();

    public EquipajeModel getEquipaje(int id);

    public void actualizarDatosEquipaje(EquipajeModel equipajeModel, int id);

    public void borrarEquipaje(int id);

    public void borrarTodosLosEquipajes();
}
