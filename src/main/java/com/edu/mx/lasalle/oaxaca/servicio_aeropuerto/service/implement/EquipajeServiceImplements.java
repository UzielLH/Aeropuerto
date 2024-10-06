package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.EquipajeRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.EquipajeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipajeServiceImplements implements EquipajeService {

    @Autowired
    private EquipajeRepository equipajeRepository;

    @Transactional
    @Override
    public EquipajeModel registrarEquipaje(EquipajeModel equipajeModel) {
        return equipajeRepository.save(equipajeModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EquipajeModel> obtenerEquipajes() {
        return (List<EquipajeModel>) equipajeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EquipajeModel> getEquipaje(int id) {
        return equipajeRepository.findByIdEquipaje(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<EquipajeModel> actualizarDatosEquipaje(EquipajeModel equipajeModel, int id) {
        Optional<EquipajeModel> equipajeOptional = equipajeRepository.findByIdEquipaje(id);
        if (equipajeOptional.isPresent()) {
            EquipajeModel equipajeActualizado = equipajeOptional.orElseThrow();
            equipajeActualizado.setAltura(equipajeModel.getAltura());
            equipajeActualizado.setAncho(equipajeModel.getAncho());
            equipajeActualizado.setTipo(equipajeModel.getTipo());
            return Optional.of(equipajeRepository.save(equipajeActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<EquipajeModel> borrarEquipaje(int id) {
        Optional<EquipajeModel> equipajeOptional = equipajeRepository.findByIdEquipaje(id);
        if (equipajeOptional.isPresent()) {
            equipajeRepository.deleteById(id);
            return equipajeOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosEquipajes() {
        equipajeRepository.deleteAll();
    }

}
