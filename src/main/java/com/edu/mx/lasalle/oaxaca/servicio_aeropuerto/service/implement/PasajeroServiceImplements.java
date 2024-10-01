package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.PasajeroRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PasajeroService;

@Service
public class PasajeroServiceImplements implements PasajeroService {
    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Override
    public void registrarPasajero(PasajeroModel pasajeroModel) {
        pasajeroRepository.save(pasajeroModel);
    }

    @Override
    public List<PasajeroModel> obtenerPasajeros() {
        return (List<PasajeroModel>) pasajeroRepository.findAll();
    }

    @Override
    public PasajeroModel getPasajeros(int id) {
        return pasajeroRepository.findById(id);
    }

    @Override
    public void actualizarDatosPasajero(PasajeroModel pasajeroModel, int id) {
        pasajeroModel.setId(id);
        pasajeroRepository.save(pasajeroModel);
    }

    @Override
    public void borrarPasajero(int id) {
        pasajeroRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosPasajeros() {
        pasajeroRepository.deleteAll();
    }
}
