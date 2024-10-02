/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tokay
 */
public interface BoletoRepository extends CrudRepository<BoletoModel, Integer> {
    public BoletoModel findById(int id);
    
}
