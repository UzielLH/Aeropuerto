package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import org.springframework.data.repository.CrudRepository;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;

public interface PasajeroRepository extends CrudRepository<PasajeroModel, Integer> {
    public PasajeroModel findById(int id);
}
