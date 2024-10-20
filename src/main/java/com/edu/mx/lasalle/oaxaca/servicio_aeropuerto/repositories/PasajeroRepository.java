package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;

public interface PasajeroRepository extends CrudRepository<PasajeroModel, Integer> {
    @Query("SELECT p FROM PasajeroModel p WHERE p.boletoModel.vuelo.id = :vueloId")
    List<PasajeroModel> findPasajerosByVueloId(@Param("vueloId") int vueloId);
}
