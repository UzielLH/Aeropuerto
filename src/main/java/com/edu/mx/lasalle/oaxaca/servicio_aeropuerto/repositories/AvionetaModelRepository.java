/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionetaModel;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ferrc
 */
public interface AvionetaModelRepository extends CrudRepository<AvionetaModel, Integer> {
    public Optional<AvionetaModel> findByMatricula(int matricula);
}