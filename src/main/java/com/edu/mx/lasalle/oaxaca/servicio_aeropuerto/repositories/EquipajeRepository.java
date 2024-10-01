package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;
import org.springframework.data.repository.CrudRepository;

public interface EquipajeRepository extends CrudRepository<EquipajeModel, Integer> {
    public EquipajeModel findById(int id);
}
