package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.PasajeroRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PasajeroService;

@Service
public class PasajeroServiceImplements implements PasajeroService {
    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Transactional
    @Override
    public PasajeroModel registrarPasajero(PasajeroModel pasajeroModel) {
        return pasajeroRepository.save(pasajeroModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PasajeroModel> obtenerPasajeros() {
        return (List<PasajeroModel>) pasajeroRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PasajeroModel> getPasajeros(int id) {
        return pasajeroRepository.findById(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<PasajeroModel> actualizarDatosPasajero(PasajeroModel pasajeroModel, int id) {
        Optional<PasajeroModel> pasajeroOptional = pasajeroRepository.findById(id);
        if (pasajeroOptional.isPresent()) {
            PasajeroModel pasajeroActualizado = pasajeroOptional.orElseThrow();
            pasajeroActualizado.setNombre(pasajeroModel.getNombre());
            pasajeroActualizado.setApellido(pasajeroModel.getApellido());
            pasajeroActualizado.setDireccion(pasajeroModel.getDireccion());
            pasajeroActualizado.setFechaNacimiento(pasajeroModel.getFechaNacimiento());
            pasajeroActualizado.setDiscapacidad(pasajeroModel.getDiscapacidad());
            pasajeroActualizado.setNacionalidad(pasajeroModel.getNacionalidad());

            // Actualizar BoletoModel
            BoletoModel boletoActualizado = pasajeroActualizado.getBoletoModel();
            BoletoModel boletoNuevo = pasajeroModel.getBoletoModel();
            if (boletoActualizado != null && boletoNuevo != null) {
                boletoActualizado.setAsiento(boletoNuevo.getAsiento());
                boletoActualizado.setCosto(boletoNuevo.getCosto());
                boletoActualizado.setVuelo(boletoNuevo.getVuelo());
            }

            return Optional.of(pasajeroRepository.save(pasajeroActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<PasajeroModel> borrarPasajero(int id) {
        Optional<PasajeroModel> pasajeroOptional = pasajeroRepository.findById(id);
        if (pasajeroOptional.isPresent()) {
            pasajeroRepository.deleteById(id);
            return pasajeroOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosPasajeros() {
        pasajeroRepository.deleteAll();
    }

}
