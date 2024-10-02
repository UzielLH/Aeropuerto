/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Aeropuerto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ferrc
 */
public interface AeropuertoRepository extends CrudRepository<Aeropuerto, Integer> {
    public Aeropuerto findByClaveAeropuerto(int claveAeropuerto);
}