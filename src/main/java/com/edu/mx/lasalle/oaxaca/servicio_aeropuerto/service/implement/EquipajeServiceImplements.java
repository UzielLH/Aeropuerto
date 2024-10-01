package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.EquipajeRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.EquipajeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipajeServiceImplements implements EquipajeService {

    @Autowired
    private EquipajeRepository equipajeRepository;

    @Override
    public void registrarEquipaje(EquipajeModel equipajeModel) {
        equipajeRepository.save(equipajeModel);
    }

    @Override
    public List<EquipajeModel> obtenerEquipajes() {
        return (List<EquipajeModel>) equipajeRepository.findAll();
    }

    @Override
    public EquipajeModel getEquipaje(int id) {
        return equipajeRepository.findById(id);
    }

    @Override
    public void actualizarDatosEquipaje(EquipajeModel equipajeModel, int id) {
        equipajeModel.setId(id);
        equipajeRepository.save(equipajeModel);
    }

    @Override
    public void borrarEquipaje(int id) {
        equipajeRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosEquipajes() {
        equipajeRepository.deleteAll();
    }

}
