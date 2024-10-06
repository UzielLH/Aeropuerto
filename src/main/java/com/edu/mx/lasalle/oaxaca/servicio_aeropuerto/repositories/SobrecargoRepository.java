/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tokay
 */
public interface SobrecargoRepository extends CrudRepository<SobrecargoModel, Integer> {
        public Optional<SobrecargoModel> findByIdTripulacion(int id);
}
