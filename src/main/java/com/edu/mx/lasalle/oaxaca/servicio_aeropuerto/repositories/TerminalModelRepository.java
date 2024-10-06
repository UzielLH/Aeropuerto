/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ferrc
 */
public interface TerminalModelRepository extends CrudRepository<TerminalModel, Integer> {
    public Optional<TerminalModel> findByClaveTerminal(int claveTerminal);
}
